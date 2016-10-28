package com.yancey.manager.domain;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import com.yancey.manager.query.BaseAbstractQuery;
import com.yancey.manager.util.DataGridModel;

public class Apk extends BaseAbstractQuery {

  private Integer         apkId;
  private Integer[]       lableId;
  private Integer         lbId;
  private String          apkName;
  private String          hot;
  private String          characteristic;
  private String          briefIntroduction;
  private String          description;
  private Integer         downloadNum;
  private Integer         versionCode;
  private String          versionName;
  private String          fileMd5;
  private Integer         fileSize;
  private String          packageName;
  private String          fileName;
  private String          downloadUrl;
  private String          localPath;
  private Integer         pngIconId;
  private Integer         jpgIconId;
  private Integer         status;
  private String          mark;
  private Integer         creator;
  private Date            createTime;
  private Date            modifyTime;
  private DataGridModel   pageInfo;
  private String          hdImageUrl;
  private String          nhdImageUrl;
  private String          labelName;
  private Image           icon;             // 应用图标
  private List<Image>     images;           // 应用截图
  private String          from;
  private List<Integer>   userIdList;
  private Integer         flag;             // 区分是否是第三方抓取字段

  private Integer         imgId;
  private Integer         type;
  private String          company;          // 开发者
  private String          cType;            // 查全部应用的时候区分是查天奕达的全部应用还是查其他合作商的全部应用
  private Integer         companyType;      // 区分天奕达（1）、第三方(0)、其他合作商(2)
  private Integer[]       imageAry;
  private Integer[]       oldImageAry;
  private Integer         isIcon;
  private Integer         apkCode;

  
  
  public Integer[] getImageAry() {
    return imageAry;
  }

  public void setImageAry(Integer[] imageAry) {
    this.imageAry = imageAry;
  }

  public Integer[] getOldImageAry() {
    return oldImageAry;
  }

  public void setOldImageAry(Integer[] oldImageAry) {
    this.oldImageAry = oldImageAry;
  }

  public Integer getIsIcon() {
    return isIcon;
  }

  public void setIsIcon(Integer isIcon) {
    this.isIcon = isIcon;
  }

  public Integer getApkCode() {
    return apkCode;
  }

  public void setApkCode(Integer apkCode) {
    this.apkCode = apkCode;
  }

  public Integer getCompanyType() {
    return companyType;
  }

  public void setCompanyType(Integer companyType) {
    this.companyType = companyType;
  }

  public String getcType() {
    return cType;
  }

  public void setcType(String cType) {
    this.cType = cType;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Integer getFlag() {
    return flag;
  }

  public void setFlag(Integer flag) {
    this.flag = flag;
  }

  public Integer getImgId() {
    return imgId;
  }

  public void setImgId(Integer imgId) {
    this.imgId = imgId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getLbId() {
    return lbId;
  }

  public void setLbId(Integer lbId) {
    this.lbId = lbId;
  }

  public List<Integer> getUserIdList() {
    return userIdList;
  }

  public void setUserIdList(List<Integer> userIdList) {
    this.userIdList = userIdList;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Integer getApkId() {
    return apkId;
  }

  public void setApkId(Integer apkId) {
    this.apkId = apkId;
  }

  public String getApkName() {
    return apkName;
  }

  public void setApkName(String apkName) {
    this.apkName = apkName;
  }

  public String getHot() {
    return hot;
  }

  public void setHot(String hot) {
    this.hot = hot;
  }

  public String getCharacteristic() {
    return characteristic;
  }

  public void setCharacteristic(String characteristic) {
    this.characteristic = characteristic;
  }

  public String getBriefIntroduction() {
    return briefIntroduction;
  }

  public void setBriefIntroduction(String briefIntroduction) {
    this.briefIntroduction = briefIntroduction;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getDownloadNum() {
    return downloadNum;
  }

  public void setDownloadNum(Integer downloadNum) {
    this.downloadNum = downloadNum;
  }

  public Integer getVersionCode() {
    return versionCode;
  }

  public void setVersionCode(Integer versionCode) {
    this.versionCode = versionCode;
  }

  public String getVersionName() {
    return versionName;
  }

  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

  public String getFileMd5() {
    return fileMd5;
  }

  public void setFileMd5(String fileMd5) {
    this.fileMd5 = fileMd5;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  public String getLocalPath() {
    return localPath;
  }

  public void setLocalPath(String localPath) {
    this.localPath = localPath;
  }

  public Integer getPngIconId() {
    return pngIconId;
  }

  public void setPngIconId(Integer pngIconId) {
    this.pngIconId = pngIconId;
  }

  public Integer getJpgIconId() {
    return jpgIconId;
  }

  public void setJpgIconId(Integer jpgIconId) {
    this.jpgIconId = jpgIconId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public Integer getCreator() {
    return creator;
  }

  public void setCreator(Integer creator) {
    this.creator = creator;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public DataGridModel getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
  }

  public Integer[] getLableId() {
    return lableId;
  }

  public void setLableId(Integer[] lableId) {
    this.lableId = lableId;
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

  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public Image getIcon() {
    return icon;
  }

  public void setIcon(Image icon) {
    this.icon = icon;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

}