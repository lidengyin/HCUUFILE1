package cn.hctech2006.hcuufile.mapper;

import cn.hctech2006.hcuufile.bean.HcUuType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HcUuTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HcUuType record);

    HcUuType selectByPrimaryKey(Long id);

    List<HcUuType> selectAll();

    int updateByPrimaryKey(HcUuType record);
    //根据类型名获取类型
    HcUuType selectByName(String name);
}