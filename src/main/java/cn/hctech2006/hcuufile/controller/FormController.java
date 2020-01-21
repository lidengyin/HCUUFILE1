package cn.hctech2006.hcuufile.controller;

import cn.hctech2006.hcuufile.bean.HcUuForm;
import cn.hctech2006.hcuufile.bean.RespBean;
import cn.hctech2006.hcuufile.service.FormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文件类型接口")
@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    private FormService formService;
    @ApiOperation(value = "获取全部文件类型", notes = "获取的都是已知固有的属性")
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping("/find/all")

    public RespBean findAll(){
        try{
            List<HcUuForm> hcUuForms = formService.findAllForm();
            return RespBean.ok("获取全部类型",hcUuForms);
        }catch(Exception e){
            e.printStackTrace();
            return RespBean.error("获取类型失败");
        }
    }
    @ApiOperation(value = "根据ID获取文件类型", notes = "根据ID获取文件类型")
    @ApiImplicitParam(type = "query", name = "id", value = "文件类型ID",required = true)
    @CrossOrigin(maxAge = 3600,origins = "*", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping("/find/id")
    public RespBean findById(Integer id){
        try{
            HcUuForm hcUuForm = formService.findById(id);
            return RespBean.ok("获取成功",hcUuForm);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("获取失败");
        }
    }

}
