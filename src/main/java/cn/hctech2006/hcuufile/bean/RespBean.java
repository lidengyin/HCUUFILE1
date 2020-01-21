package cn.hctech2006.hcuufile.bean;

import java.io.Serializable;

/**
 * 封装结果函数
 */
public class RespBean implements Serializable {
    private Integer status;
    private String msg;
    private Object obj;
    private RespBean(){};
    public RespBean(Integer status, String msg, Object obj){
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public RespBean setObj(Object obj) {
        this.obj = obj;
        return this;
    }

    public static RespBean builder(){
        return new RespBean();
    }
    public static RespBean ok(String msg, Object obj){
        return new RespBean(200, msg, obj);
    }
    public static RespBean ok(String msg){
        return new RespBean(200, msg, null);
    }
    public static RespBean error(String msg, Object obj){
        return new RespBean(500, msg, obj);
    }
    public static RespBean error(String msg){
        return new RespBean(500, msg, null);
    }

}
