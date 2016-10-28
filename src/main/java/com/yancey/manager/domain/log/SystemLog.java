package com.yancey.manager.domain.log;

import java.util.Date;

import com.yancey.manager.domain.BaseEntity;

public class SystemLog extends BaseEntity {

  /**
   * 
   */
  private static final long serialVersionUID = -7524472462532766073L;

  private int               userId;

  private String            username;

  private String            exeOperation;

  private Date              createtime;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getExeOperation() {
    return exeOperation;
  }

  public void setExeOperation(String exeOperation) {
    this.exeOperation = exeOperation;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

}
