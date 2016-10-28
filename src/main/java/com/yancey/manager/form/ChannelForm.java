package com.yancey.manager.form;

import com.yancey.manager.util.DataGridModel;

public class ChannelForm {

  private Integer       id;
  private String        channelId;
  private String        channelName;
  private String        channelBusiness;
  private String        description;
  private DataGridModel pageInfo;       // 分页
  private Integer       userId;

  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public DataGridModel getPageInfo() {
    return pageInfo;
  }
  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
  }
  public String getChannelId() {
    return channelId;
  }
  public void setChannelId(String channelId) {
    this.channelId = channelId;
  }
  public String getChannelName() {
    return channelName;
  }
  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }
  public String getChannelBusiness() {
    return channelBusiness;
  }
  public void setChannelBusiness(String channelBusiness) {
    this.channelBusiness = channelBusiness;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  @Override
  public String toString() {
    return "ChannelForm [id=" + id + ", channelId=" + channelId + ", channelName=" + channelName + ", channelBusiness=" + channelBusiness + ", description="
        + description + ", pageInfo=" + pageInfo + "]";
  }
}
