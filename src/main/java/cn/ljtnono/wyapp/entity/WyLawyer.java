package cn.ljtnono.wyapp.entity;

import java.io.Serializable;

/**
 * wy_lawyer
 * @author 
 */
public class WyLawyer implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 关联的用户表外键
     */
    private String userId;

    /**
     * 律师证编号
     */
    private String laywerId;

    /**
     * 律师机构
     */
    private String institution;

    /**
     * 服务地区 数字编号，详情查看笔记相关内容
     */
    private Integer serverArea;

    /**
     * 0: 刑事辩护 1：民事辩护 2：行政辩护
     */
    private Integer domain;

    /**
     * 办公地址
     */
    private String serviceAddr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLaywerId() {
        return laywerId;
    }

    public void setLaywerId(String laywerId) {
        this.laywerId = laywerId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getServerArea() {
        return serverArea;
    }

    public void setServerArea(Integer serverArea) {
        this.serverArea = serverArea;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public String getServiceAddr() {
        return serviceAddr;
    }

    public void setServiceAddr(String serviceAddr) {
        this.serviceAddr = serviceAddr;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WyLawyer other = (WyLawyer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLaywerId() == null ? other.getLaywerId() == null : this.getLaywerId().equals(other.getLaywerId()))
            && (this.getInstitution() == null ? other.getInstitution() == null : this.getInstitution().equals(other.getInstitution()))
            && (this.getServerArea() == null ? other.getServerArea() == null : this.getServerArea().equals(other.getServerArea()))
            && (this.getDomain() == null ? other.getDomain() == null : this.getDomain().equals(other.getDomain()))
            && (this.getServiceAddr() == null ? other.getServiceAddr() == null : this.getServiceAddr().equals(other.getServiceAddr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLaywerId() == null) ? 0 : getLaywerId().hashCode());
        result = prime * result + ((getInstitution() == null) ? 0 : getInstitution().hashCode());
        result = prime * result + ((getServerArea() == null) ? 0 : getServerArea().hashCode());
        result = prime * result + ((getDomain() == null) ? 0 : getDomain().hashCode());
        result = prime * result + ((getServiceAddr() == null) ? 0 : getServiceAddr().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", laywerId=").append(laywerId);
        sb.append(", institution=").append(institution);
        sb.append(", serverArea=").append(serverArea);
        sb.append(", domain=").append(domain);
        sb.append(", serviceAddr=").append(serviceAddr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}