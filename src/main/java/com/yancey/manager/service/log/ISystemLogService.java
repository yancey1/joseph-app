package com.yancey.manager.service.log;

import com.yancey.manager.domain.log.SystemLog;

public interface ISystemLogService {

  /**
   * 保存系统日志
   * 
   * @param log
   * */
  public boolean saveSystemLog(SystemLog log);

  public void updateTest();

}
