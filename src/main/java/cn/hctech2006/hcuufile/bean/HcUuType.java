package cn.hctech2006.hcuufile.bean;

import java.io.Serializable;
import java.util.Date;

public class HcUuType implements Serializable {
    private Long id;

    private String typeNamezh;

    private String typeName;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String typeEnable;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeNamezh() {
        return typeNamezh;
    }

    public void setTypeNamezh(String typeNamezh) {
        this.typeNamezh = typeNamezh;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getTypeEnable() {
        return typeEnable;
    }

    public void setTypeEnable(String typeEnable) {
        this.typeEnable = typeEnable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeNamezh=").append(typeNamezh);
        sb.append(", typeName=").append(typeName);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", typeEnable=").append(typeEnable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}