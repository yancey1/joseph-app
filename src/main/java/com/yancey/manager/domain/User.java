package com.yancey.manager.domain;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.yancey.manager.form.ChannelForm;
import com.yancey.manager.form.MenuForm;
import com.yancey.manager.util.CustomDateTimeSerializer;

public class User {

  private Integer           userId;      // 用户uid
  private String            userName;    // 登录用户名
  private String            nickname;    // 用户昵称
  private String            password;    // 密码
  private String            status;      // 1:启用 0:禁用
  private String            description; // 备注
  private Date              createTime;  //
  private Date              modifyTime;  // 手机号
  private String            pyUserName;  // 朋越账号
  private String            pyPassword;  // 朋越账号密码
  private Integer[]         roleId;
  private List<Role>        roles;       //
  private String            roleNames;
  private List<UserMarket>  markets;
  private List<ChannelForm> channelForms;
  private List<MenuForm>    menuForms;
  private String            companyId;
  private Company           company;
  private String            roleName;

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public List<MenuForm> getMenuForms() {
    return menuForms;
  }

  public void setMenuForms(List<MenuForm> menuForms) {
    this.menuForms = menuForms;
  }

  public List<ChannelForm> getChannelForms() {
    return channelForms;
  }

  public void setChannelForms(List<ChannelForm> channelForms) {
    this.channelForms = channelForms;
  }

  public List<UserMarket> getMarkets() {
    return markets;
  }

  public void setMarkets(List<UserMarket> markets) {
    this.markets = markets;
  }

  public String getRoleNames() {
    return roleNames;
  }

  public void setRoleNames(String roleNames) {
    this.roleNames = roleNames;
  }

  public User() {
    super();
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getPyUserName() {
    return pyUserName;
  }

  public void setPyUserName(String pyUserName) {
    this.pyUserName = pyUserName;
  }

  public String getPyPassword() {
    return pyPassword;
  }

  public void setPyPassword(String pyPassword) {
    this.pyPassword = pyPassword;
  }

  public Integer[] getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer[] roleId) {
    this.roleId = roleId;
  }
  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", userName=" + userName + ", nickname=" + nickname + ", password=" + password + ", status=" + status + ", description="
        + description + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
  }

}
