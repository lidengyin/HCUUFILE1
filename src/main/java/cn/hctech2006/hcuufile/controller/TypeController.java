package cn.hctech2006.hcuufile.controller;

import cn.hctech2006.hcuufile.bean.HcUuType;
import cn.hctech2006.hcuufile.bean.RespBean;
import cn.hctech2006.hcuufile.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Api(tags = "资源类型接口")
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    //@ApiOperation(value = "获取所有类型",notes = "获取所有类型")
    @GetMapping("/find/all")
    public RespBean findAllType(){
        try{
            List<HcUuType> types = typeService.findAllType();
            return RespBean.ok("获取成功",types);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("获取失败");
        }
    }

}
