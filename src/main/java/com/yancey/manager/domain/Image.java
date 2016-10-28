package com.yancey.manager.domain;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.yancey.manager.query.BaseAbstractQuery;
import com.yancey.manager.util.CustomDateTimeSerializer;

public class Image extends BaseAbstractQuery {

  private Integer       imageId;
  private String        imageName;
  private Integer       imageType;
  private Integer       imageWidth;
  private Integer       imageHeight;
  private String        hdImageUrl;
  private String        nhdImageUrl;
  private Integer       display;
  private Integer       status;
  private Integer       creator;
  private Date          createTime;
  private Date          modifyTime;
  private String        md5;
  private String        smallImageUrl;

  private List<Integer> imageList;

  public List<Integer> getImageList() {
    return imageList;
  }

  public void setImageList(List<Integer> imageList) {
    this.imageList = imageList;
  }

  public String getSmallImageUrl() {
    return smallImageUrl;
  }

  public void setSmallImageUrl(String smallImageUrl) {
    this.smallImageUrl = smallImageUrl;
  }

  public String getMd5() {
    return md5;
  }

  public void setMd5(String md5) {
    this.md5 = md5;
  }

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }
  public Integer getImageType() {
    return imageType;
  }

  public void setImageType(Integer imageType) {
    this.imageType = imageType;
  }

  public Integer getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(Integer imageWidth) {
    this.imageWidth = imageWidth;
  }

  public Integer getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(Integer imageHeight) {
    this.imageHeight = imageHeight;
  }
  public String getHdImageUrl() {
    return hdImageUrl;
  }

  public void setHdImageUrl(String hdImageUrl) {
    this.hdImageUrl = hdImageUrl;
  }

  public String getNhdImageUrl() {
    return nhdImageUrl;
  }

  public void setNhdImageUrl(String nhdImageUrl) {
    this.nhdImageUrl = nhdImageUrl;
  }

  public Integer getDisplay() {
    return display;
  }

  public void setDisplay(Integer display) {
    this.display = display;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getCreator() {
    return creator;
  }

  public void setCreator(Integer creator) {
    this.creator = creator;
  }

  @JsonSerialize(using = CustomDateTimeSerializer.class)
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @JsonSerialize(using = CustomDateTimeSerializer.class)
  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }
}