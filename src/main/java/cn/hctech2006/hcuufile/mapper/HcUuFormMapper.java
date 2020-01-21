package cn.hctech2006.hcuufile.mapper;

import cn.hctech2006.hcuufile.bean.HcUuForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HcUuFormMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HcUuForm record);

    HcUuForm selectByPrimaryKey(Integer id);

    List<HcUuForm> selectAll();

    int updateByPrimaryKey(HcUuForm record);
}