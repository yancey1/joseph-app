package com.yancey.manager.form;

import java.util.Date;

import com.yancey.manager.util.DataGridModel;

public class RoleForm {

  private Integer       roleId;     // 角色id】
  private String        roleName;   // 角色名称
  private String        roles;       // 角色代码
  private String        description; // 备注
  private Date          createTime; // 创建时间
  private Date          modifyTime;  // 修改时间
  private DataGridModel pageInfo;   // 分页

  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
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

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DataGridModel getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
  }

}
