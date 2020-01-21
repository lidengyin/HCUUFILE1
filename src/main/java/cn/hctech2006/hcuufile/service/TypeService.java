package cn.hctech2006.hcuufile.service;

import cn.hctech2006.hcuufile.bean.HcUuType;
import cn.hctech2006.hcuufile.mapper.HcUuTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private HcUuTypeMapper hcUuTypeMapper;
    //根据资源名获取资源
    public HcUuType findByName(String name){
        return hcUuTypeMapper.selectByName(name);
    }
    //获取所有资源
    public List<HcUuType> findAllType(){
        return hcUuTypeMapper.selectAll();
    }
}
