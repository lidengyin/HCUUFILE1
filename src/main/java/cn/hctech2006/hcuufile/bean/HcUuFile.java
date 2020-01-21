package cn.hctech2006.hcuufile.bean;

import java.io.Serializable;
import java.util.Date;

public class HcUuFile implements Serializable {
    private Long id;

    private String fileRealName;

    private String fileUrlUrl;

    private String fileUrlName;

    private String fileUploadYear;

    private String fileType;

    private Date fileUrlTime;

    private String fileEnable;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private String fileSize;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName;
    }

    public String getFileUrlUrl() {
        return fileUrlUrl;
    }

    public void setFileUrlUrl(String fileUrlUrl) {
        this.fileUrlUrl = fileUrlUrl;
    }

    public String getFileUrlName() {
        return fileUrlName;
    }

    public void setFileUrlName(String fileUrlName) {
        this.fileUrlName = fileUrlName;
    }

    public String getFileUploadYear() {
        return fileUploadYear;
    }

    public void setFileUploadYear(String fileUploadYear) {
        this.fileUploadYear = fileUploadYear;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getFileUrlTime() {
        return fileUrlTime;
    }

    public void setFileUrlTime(Date fileUrlTime) {
        this.fileUrlTime = fileUrlTime;
    }

    public String getFileEnable() {
        return fileEnable;
    }

    public void setFileEnable(String fileEnable) {
        this.fileEnable = fileEnable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileRealName=").append(fileRealName);
        sb.append(", fileUrlUrl=").append(fileUrlUrl);
        sb.append(", fileUrlName=").append(fileUrlName);
        sb.append(", fileUploadYear=").append(fileUploadYear);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileUrlTime=").append(fileUrlTime);
        sb.append(", fileEnable=").append(fileEnable);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}