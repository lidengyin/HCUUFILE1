package cn.hctech2006.hcuufile.bean;

import java.io.Serializable;
import java.util.Date;

public class HcUuFormCode implements Serializable {
    private Integer id;

    private String codeName;

    private String codeHex;

    private Integer codeFormId;

    private String codeIntro;

    private Date createTime;

    private String createBy;

    private Date lastUpdateTime;

    private String lastUpdateBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeHex() {
        return codeHex;
    }

    public void setCodeHex(String codeHex) {
        this.codeHex = codeHex;
    }

    public Integer getCodeFormId() {
        return codeFormId;
    }

    public void setCodeFormId(Integer codeFormId) {
        this.codeFormId = codeFormId;
    }

    public String getCodeIntro() {
        return codeIntro;
    }

    public void setCodeIntro(String codeIntro) {
        this.codeIntro = codeIntro;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", codeName=").append(codeName);
        sb.append(", codeHex=").append(codeHex);
        sb.append(", codeFormId=").append(codeFormId);
        sb.append(", codeIntro=").append(codeIntro);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateBy=").append(lastUpdateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}