package cn.ljtnono.wyapp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * wy_image
 * @author 
 */
public class WyImage implements Serializable {
    /**
     * 图片的主键
     */
    private String id;

    /**
     * 图片的路径
     */
    private String imageUrl;

    /**
     * 图片上传时间
     */
    private Date imageUploadTime;

    /**
     * 图片上次最后修改时间
     */
    private Date imageModifyTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getImageUploadTime() {
        return imageUploadTime;
    }

    public void setImageUploadTime(Date imageUploadTime) {
        this.imageUploadTime = imageUploadTime;
    }

    public Date getImageModifyTime() {
        return imageModifyTime;
    }

    public void setImageModifyTime(Date imageModifyTime) {
        this.imageModifyTime = imageModifyTime;
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
        WyImage other = (WyImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getImageUploadTime() == null ? other.getImageUploadTime() == null : this.getImageUploadTime().equals(other.getImageUploadTime()))
            && (this.getImageModifyTime() == null ? other.getImageModifyTime() == null : this.getImageModifyTime().equals(other.getImageModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getImageUploadTime() == null) ? 0 : getImageUploadTime().hashCode());
        result = prime * result + ((getImageModifyTime() == null) ? 0 : getImageModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", imageUploadTime=").append(imageUploadTime);
        sb.append(", imageModifyTime=").append(imageModifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}