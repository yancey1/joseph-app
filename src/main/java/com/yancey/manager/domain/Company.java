package com.yancey.manager.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.yancey.manager.util.CustomDateTimeSerializer;
import com.yancey.manager.util.DataGridModel;

public class Company {
  private String        companyId;
  private String        companyName;
  private Date          createTime;
  private Date          modifyTime;
  private DataGridModel pageInfo;

  public DataGridModel getPageInfo() {
    return pageInfo;
  }
  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
  }
  public String getCompanyId() {
    return companyId;
  }
  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }
  public String getCompanyName() {
    return companyName;
  }
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
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
