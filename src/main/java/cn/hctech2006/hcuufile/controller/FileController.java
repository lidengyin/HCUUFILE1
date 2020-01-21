package cn.hctech2006.hcuufile.controller;
import cn.hctech2006.hcuufile.bean.*;
import cn.hctech2006.hcuufile.config.FileTypeJudge;
import cn.hctech2006.hcuufile.service.FileService;
import cn.hctech2006.hcuufile.service.FormCodeService;
import cn.hctech2006.hcuufile.service.FormService;
import cn.hctech2006.hcuufile.service.TypeService;
import cn.hctech2006.hcuufile.util.HttpUtils;
import com.github.pagehelper.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Api(tags = "文件传输接口",value = "文件传输接口")
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private FormCodeService formCodeService;
    @Autowired
    private FormService formService;
    @ApiOperation(value = "文件上传", notes = "单文件上传")
    @ApiImplicitParams({
            //@ApiImplicitParam(type = "query", name = "createBy", value = "上传者", required = true)
    })
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public RespBean uploadFile(@ApiParam(value = "上传文件",required = true) MultipartFile uploadFile ,HttpServletRequest request,Authentication authentication)throws IOException {
        try{
            if(uploadFile.getInputStream() == null){
                System.out.println("inputStream is null");
            }
            //测试十六进制转换文件类型
            String type = FileTypeJudge.getFileType(uploadFile.getInputStream());
            System.out.println("typeHexCode:"+type);
            HcUuFormCode hcUuFormCode = formCodeService.findByRecordHex(type);
            System.out.println("hcUuFormCode.type:"+hcUuFormCode.getCodeName());
            HcUuForm hcUuForm = formService.findById(hcUuFormCode.getCodeFormId());
            System.out.println("hcUuForm.name:"+hcUuForm.getFormName());
            //获取文件类型
            String content_form = hcUuForm.getFormName();
            String content_type = uploadFile.getContentType().split("/")[0];
            System.out.println("uploadFile.getContentType:"+content_type);
            //获取初始化文件名
            String file_name = uploadFile.getOriginalFilename();
            //获取寻找目录文件名
            String file_url_name = UUID.randomUUID()+file_name.substring(file_name.lastIndexOf("."));
            System.out.println("uploadFile.getOriginalFileName:"+file_name);
            System.out.println("file_url_name:"+file_url_name);
            //1K=1024bytes(字节)
            //获取文件大小
            DecimalFormat df = new DecimalFormat("######0.00");
            Long size = uploadFile.getSize();
            System.out.println("uploadFile.getSize:"+df.format(1.0*uploadFile.getSize()/(1024*1024))+"M");
            //存储到数据库
            HcUuFile hcUuFile = new HcUuFile();
            //获取作为目录时间
            hcUuFile.setFileUrlTime(new Date());
            //获取上传年份
            hcUuFile.setFileUploadYear(hcUuFile.getFileUrlTime().toString().substring(hcUuFile.getFileUrlTime().toString().length()-4));
            System.out.println("hcUuFile.setFileUploadYear:"+hcUuFile.getFileUploadYear());
            //转移文件到服务器
            //storageFile(uploadFile, file_url_name, hcUuFile.getFileUrlTime(), content_type);
            storageFile(uploadFile, file_url_name, hcUuFile.getFileUrlTime(), content_form);
            //设置真实文件名
            hcUuFile.setFileRealName(file_name);
            //设置URL查找名
            hcUuFile.setFileUrlName(file_url_name);
            //设置文件类型,方便查找文件资源目录
            //HcUuType hcUuType = typeService.findByName(content_type);

            //文件类型编号
            //System.out.println("hcUuType:"+hcUuType.getId());
            System.out.println("hcUuForm:"+hcUuForm.getId());
            //hcUuFile.setFileType(hcUuType.getId()+"");
            hcUuFile.setFileType(hcUuForm.getId()+"");
            //设置创建时间
            hcUuFile.setCreateTime(new Date());
            //设置修改时间
            hcUuFile.setUpdateTime(new Date());

            //获取当前用户
            Object principal = authentication.getPrincipal();
            //设置创建者
            hcUuFile.setCreateBy("软件组");
            //设置修改者
            hcUuFile.setUpdateBy("软件组");
            //设置可用性
            hcUuFile.setFileEnable("1");
            //设置文件大小
            hcUuFile.setFileSize(size.toString());
            //设置本地文件路径
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            //String file_url_url = "/usr/local/spring-boot/upload/"+hcUuType.getTypeName()+"/"+sdf.format(hcUuFile.getFileUrlTime())+"/"+hcUuFile.getFileUrlName();
            //Windows
            String file_url_url = "/usr/local/spring-boot/hcuufile/upload/"+content_form+"/"+sdf.format(hcUuFile.getFileUrlTime())+"/"+hcUuFile.getFileUrlName();
            System.out.println("file_url_url:"+file_url_url);
            hcUuFile.setFileUrlUrl(file_url_url);
            //上传文件
            fileService.uploadFile(hcUuFile);
            return RespBean.ok("ok",hcUuFile);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("失败");
        }
    }

    @ApiOperation(value = "下载资源", notes = "下载资源")
    @ApiImplicitParam(type = "query", name = "id", value = "资源序号", required = true)
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping("/download")
    public RespBean downloadFile(HcUuFile file, HttpServletResponse response, HttpServletRequest request)throws IOException{
        try{
            System.out.println("id:"+file.getId());
            HcUuFile hcUuFile = fileService.findById(file);
            System.out.println("hcUuFile.getFileName:"+hcUuFile.getFileRealName());
            //文件大小(单位是字节)
            String content_length = hcUuFile.getFileSize();
            //文件下载路径
            String file_url_url = hcUuFile.getFileUrlUrl();
            //创建文件对象
            File file1 = new File(file_url_url);
            //下载显示的文件名
            String realName = hcUuFile.getFileRealName();
            //下载显示文件名解决中文乱码问题
            //realName = new String(realName.getBytes("UTF-8"),"ISO-8859-1");
            if(!file1.isDirectory()){
                RespBean.error("要下载的文件不存在");
            }
            //-----在下载是先判断是否是微软的浏览器,如果是,用UTF-8对文件名进行编码,如果不是,使用万能解决乱码
            //设置内容类型
            response.setContentType("application/octet-stream");
            //判断浏览器类型
            boolean isMSIE  = HttpUtils.isMSBrowser(request);
            if(isMSIE){
                //IE浏览器的乱码问题解决
                realName = URLEncoder.encode(realName, "UTF-8");
            }else{
                //万能乱码解绝
                realName = new String(realName.getBytes("UTF-8"), "ISO-8859-1");
            }
            //设置响应头
            //设置response得Content-disposition项时，fileName的值要加上双引号，如果不加双引号，
            // 在FixFox下载文件时，文件名是英文加中文的组合，这样在FIXFOX下载的文件名只有英文部分，
            //只有加了双引号之后，文件名和代码设置的文件名一致。因为这个双引号是在字符串中，所以需要加反斜杠\来转义
            response.setHeader("Content-disposition","attachment;filename="+realName);
            response.setContentLength(Integer.parseInt(content_length));
            //---这样就可以在IE8-11，EDGE，FIREFOX以及chrome浏览器下载文件时，中文不在乱码了
            //读取要下载的文件,保存到文件输入流
            FileInputStream in = new FileInputStream(file_url_url);
            //创建输出流
            OutputStream out = response.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            while((len = in.read(buffer)) > 0){
                out.write(buffer,0,len);
            }
            //关闭文件输入流
            in.close();
            //关闭文件输出流
            out.close();
            return RespBean.ok("下载成功",hcUuFile);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("下载失败");
        }
    }
    @ApiOperation(value = "根据年份类型可用性获取分页获取资源",notes = "根据年份类型可用性获取分页获取资源")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", value = "当前页数",required = true),
            @ApiImplicitParam(type = "query", name = "pageSize", value = "每页行数",required = true),
            @ApiImplicitParam(type = "query", name = "fileEnable", value = "资源可用性"),
            @ApiImplicitParam(type = "query", name = "fileType", value = "资源类型"),
            @ApiImplicitParam(type = "query", name = "fileUploadYear",value = "上传年份")
    })
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping("/find/yte")
    public RespBean findByYearAndTypeAndEnable(Integer pageNum, Integer pageSize, HcUuFile hcUuFile){
        try{
            Page<HcUuFile> hcUuFiles = fileService.findByYearAndTypeAndEnable(pageNum,pageSize,hcUuFile);
            List<HcUuFile> fileList = hcUuFiles.getResult();
            PageResult pageResult = new PageResult();
            pageResult.setContent(fileList);
            pageResult.setPageNum(pageNum);
            pageResult.setPageSize(pageSize);
            pageResult.setTotalPages(hcUuFiles.getPages());
            pageResult.setTotalSize(hcUuFiles.getTotal());

            return RespBean.ok("获取资源成功",pageResult);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("获取资源失败");
        }
    }
    @ApiOperation(value = "更改资源可用性",notes = "更改资源可用性")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "id", value = "资源ID",required = true),
            @ApiImplicitParam(type = "query", name = "fileEnable", value = "资源可用性",required = true)
    })
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping("/update/enable")
    public RespBean updateEnable(HcUuFile hcUuFile){
        try{
            fileService.updateEnableByPrimaryKey(hcUuFile);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("修改失败");
        }
    }
    //存储文件到临时目录，并返回url文件名
    public String storageFile(MultipartFile file, String newName, Date date, String form) throws IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //String realPath = "/usr/local/spring-boot/upload/"+type+"/"+sdf.format(date);
        //Windows
        String realPath = "/usr/local/spring-boot/hcuufile/upload/"+form+"/"+sdf.format(date);
        File folder = new File(realPath);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        file.transferTo(new File(folder,newName));
        return newName;
    }
}
