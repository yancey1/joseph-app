package com.yancey.manager.service.impl.log;

import com.yancey.manager.annotation.Action;
import com.yancey.manager.domain.log.SystemLog;
import com.yancey.manager.service.log.ISystemLogService;

public class SystemLogServiceImpl implements ISystemLogService {

  public boolean saveSystemLog(SystemLog log) {
    System.out.println("log-->" + log.toString());

    return true;
  }

  @Action(description = "test")
  public void updateTest() {
    System.out.println("enter here!");
  }

}
