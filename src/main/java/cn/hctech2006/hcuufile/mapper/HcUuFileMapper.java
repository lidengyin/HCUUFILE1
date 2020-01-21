package cn.hctech2006.hcuufile.mapper;

import cn.hctech2006.hcuufile.bean.HcUuFile;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HcUuFileMapper {

    //根据年份获取文件
    Page<HcUuFile> selectByYear(HcUuFile hcUuFile);
    //根据类型获取文件
    Page<HcUuFile> selectByType(HcUuFile hcUuFile);
    //根据年份和类型获取文件
    Page<HcUuFile> selectByYearAndTypeAndEnable(HcUuFile hcUuFile);
    //获取所有类型
    Page<String> selectAllType(HcUuFile hcUuFile);
    //获取所有年份
    Page<String> selectAllYear(HcUuFile hcUuFile);
    //上传文件
    int insertFile(HcUuFile hcUuFile);
    //根据可用性获取所有文件
    Page<HcUuFile> selectAll(HcUuFile hcUuFile);
    //根据ID获取文件
    HcUuFile selectByPrimaryKey(HcUuFile hcUuFile);
    //根据ID删除文件
    int deleteByPrimaryKey(Integer id);
    //根据ID修改文件
    int updateByPrimaryKey(HcUuFile hcUuFile);
    //修改文件可用性,是否可以在列表显示
    int updateFileEnableByPrimaryKey(HcUuFile hcUuFile);
}