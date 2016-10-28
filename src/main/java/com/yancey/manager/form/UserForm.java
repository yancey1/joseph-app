package com.yancey.manager.form;

import java.util.List;

import com.yancey.manager.domain.Company;
import com.yancey.manager.domain.UserRole;
import com.yancey.manager.util.DataGridModel;

public class UserForm {

  private Integer        userId;     // 用户uid
  private String         userName;   // 登录用户名
  private String         nickname;   // 用户昵称
  private String         password;   // 密码
  private String         status;     // 1:启用 0:禁用
  private String         description; // 备注
  private DataGridModel  pageInfo;
  private String         pyUserName; // 朋越账号
  private String         pyPassword; // 朋越账号密码
  private Integer[]      roleId;     //
  private List<UserRole> roles;
  private String         companyId;
  private Company        company;
  private Integer        rId;

  public Integer getrId() {
    return rId;
  }

  public void setrId(Integer rId) {
    this.rId = rId;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public List<UserRole> getRoles() {
    return roles;
  }

  public void setRoles(List<UserRole> roles) {
    this.roles = roles;
  }

  public DataGridModel getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
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

  @Override
  public String toString() {
    return "UserForm [userId=" + userId + ", userName=" + userName + ", nickname=" + nickname + ", password=" + password + ", status=" + status
        + ", description=" + description + ", pageInfo=" + pageInfo + "]";
  }

}
