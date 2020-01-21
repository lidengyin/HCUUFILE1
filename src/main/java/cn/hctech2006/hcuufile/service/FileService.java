package cn.hctech2006.hcuufile.service;

import cn.hctech2006.hcuufile.bean.HcUuFile;
import cn.hctech2006.hcuufile.mapper.HcUuFileMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    @Autowired
    private HcUuFileMapper hcUuFileMapper;
    //文件上传
    public int uploadFile(HcUuFile hcUuFile){
        return hcUuFileMapper.insertFile(hcUuFile);
    }
    //根据主键查找文件
    public HcUuFile findById(HcUuFile hcUuFile){
        return hcUuFileMapper.selectByPrimaryKey(hcUuFile);
    }
    //根据主键更新可用性
    public int updateEnableByPrimaryKey(HcUuFile hcUuFile){
        return hcUuFileMapper.updateFileEnableByPrimaryKey(hcUuFile);
    }
    //根据年份以及分页获取可用资源列表
    public Page<HcUuFile> findByYearAndTypeAndEnable(int pageNum, int pageSize, HcUuFile hcUuFile){
        PageHelper.startPage(pageNum,pageSize);
        return hcUuFileMapper.selectByYearAndTypeAndEnable(hcUuFile);
    }
}
