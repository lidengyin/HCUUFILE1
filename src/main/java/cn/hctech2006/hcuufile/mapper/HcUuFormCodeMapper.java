package cn.hctech2006.hcuufile.mapper;

import cn.hctech2006.hcuufile.bean.HcUuFormCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HcUuFormCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HcUuFormCode record);

    HcUuFormCode selectByPrimaryKey(Long id);

    List<HcUuFormCode> selectAll();

    int updateByPrimaryKey(HcUuFormCode record);

    HcUuFormCode selectByCodeHex(String Hex);
}