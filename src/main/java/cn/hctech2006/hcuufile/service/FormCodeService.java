package cn.hctech2006.hcuufile.service;

import cn.hctech2006.hcuufile.bean.HcUuFormCode;
import cn.hctech2006.hcuufile.mapper.HcUuFormCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormCodeService {
    @Autowired
    private HcUuFormCodeMapper hcUuFormCodeMapper;
    public HcUuFormCode findByRecordHex(String codeHex){
        return hcUuFormCodeMapper.selectByCodeHex(codeHex);
    }

}
