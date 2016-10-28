package com.yancey.manager.query;

import com.yancey.manager.util.DataGridModel;

public abstract class BaseAbstractQuery {

  private DataGridModel pageInfo;

  public DataGridModel getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(DataGridModel pageInfo) {
    this.pageInfo = pageInfo;
  }

}
