package cn.hctech2006.hcuufile.service;

import cn.hctech2006.hcuufile.bean.HcUuForm;
import cn.hctech2006.hcuufile.mapper.HcUuFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private HcUuFormMapper hcUuFormMapper;
    public HcUuForm findById(Integer id){
        return hcUuFormMapper.selectByPrimaryKey(id);
    }
    public List<HcUuForm> findAllForm(){
        return hcUuFormMapper.selectAll();
    }
    public HcUuForm findByid(Integer id){
        return hcUuFormMapper.selectByPrimaryKey(id);
    }
}
