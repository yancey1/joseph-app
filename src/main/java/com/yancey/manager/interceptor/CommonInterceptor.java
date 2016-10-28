package com.yancey.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yancey.manager.common.ConstantsCMP;
import com.yancey.manager.domain.User;

public class CommonInterceptor extends HandlerInterceptorAdapter {

  private final static Logger log                    = LoggerFactory.getLogger(CommonInterceptor.class);

  private final static String outsideOfficeHoursPage = "/user/login";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    User uu = (User) (request.getSession().getAttribute(ConstantsCMP.USER_SESSION_INFO));
    if (uu == null) {
      log.info("Interceptor：跳转到login页面！");
      response.sendRedirect(getRedirectUrl(request.getContextPath()));
      return false;
    } else
      return true;
  }

  private String getRedirectUrl(String contextPath){
		return String.format("%s%s",contextPath,outsideOfficeHoursPage);
	}
  
}
