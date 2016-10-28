package com.yancey.manager.domain;

import java.io.Serializable;

public class RoleMenu implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4017776113522660123L;
  private Integer           roleId;
  private Integer           resourceId;

  public Integer getRoleId() {
    return roleId;
  }
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
  public Integer getResourceId() {
    return resourceId;
  }
  public void setResourceId(Integer resourceId) {
    this.resourceId = resourceId;
  }

}
