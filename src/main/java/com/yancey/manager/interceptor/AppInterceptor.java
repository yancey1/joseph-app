package com.yancey.manager.interceptor;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yancey.manager.util.Md5Encipher;
import com.yancey.manager.util.ResponseUtils;
import com.yancey.manager.util.ReturnJsonCode;

public class AppInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(AppInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		/*//debug 模式开启
		Boolean debug = false;
		debug = Boolean.valueOf(PropertiesUtil.getProperty("debug"));
		if(debug){
			return true;
		}*/
		if(true){
			return true;
		}
		Map<String, String[]> paramMap = request.getParameterMap();
		String appKey = request.getParameter("appKey");
		String deviceId = request.getParameter("deviceId");
		String osType = request.getParameter("osType");
		String version = request.getParameter("version");
		String sign = request.getParameter("sign");
		
		if(StringUtils.isBlank(appKey) || StringUtils.isBlank(sign) || StringUtils.isBlank(deviceId)
				|| StringUtils.isBlank(osType) 
				|| StringUtils.isBlank(version)){
			logger.info("系统参数错误，请求路径[{}], 参数[{}]", request.getRequestURL(), paramMap.toString());
			ResponseUtils.responseError(response, ReturnJsonCode.MsgCodeEnum.ERRORPARAM.getMsg());
			return false;
		}
		
		
		//根据AppKey获取appSercet
		String appSecret = "10010".equals(appKey) ? "123456" : null;
		if(StringUtils.isBlank(appSecret)){
			logger.info("非法客户端请求，请求路径[{}], 参数[{}]", request.getRequestURL(), paramMap.toString());
			ResponseUtils.responseError(response, ReturnJsonCode.MsgCodeEnum.ILLEGALCLIENT.getMsg());
			return false;
		}
		
		//签名校验
		if(!checkSign(request, sign, appSecret, paramMap)){
			ResponseUtils.responseError(response, ReturnJsonCode.MsgCodeEnum.ERRORSIGN.getMsg());
			return false;
		}
		
		//解决跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		return true;
	}

	/**
	 * 签名校验 
	 * @param request
	 * @param sign
	 * @param appKey
	 * @param paramMap
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private Boolean checkSign(HttpServletRequest request, String sign, String appSecret, Map<String, String[]> paramMap) throws UnsupportedEncodingException{
		//所有请求参数按参数名升序排序；
		List<String> paramNames = new ArrayList<String>(paramMap.keySet()); 
		Collections.sort(paramNames);
		//按请求参数名及参数值相互连接组成一个字符串：<paramName1><paramValue1><paramName2><paramValue2>…；
		//将应用密钥分别添加到以上请求参数串的头部和尾部：<secret><请求参数字符串><secret>；
		StringBuffer sb = new StringBuffer(appSecret);
		for(String paramName : paramNames){
			//签名与联系人不参与签名
			if(paramName.equals("sign") || paramName.equals("contacts")){
				continue;
			}
			sb.append(paramName);
			if(StringUtils.isNotBlank(request.getParameter(paramName))){
				sb.append(request.getParameter(paramName));
			}else{
				sb.append("");
			}
		}
		sb.append(appSecret);
		//对该字符串进行Md5运算，得到一个字符串；该字符串即是这些请求参数对应的签名； s比较签名是否正确 
		String  reSign= Md5Encipher.getMD5(URLEncoder.encode(sb.toString().trim(), "utf-8"));
		if(sign.toUpperCase().equals(reSign.toUpperCase())){
			return true;
		}else{
			logger.info("非法客户端请求，请求路径[{}], 机密串[{}]", request.getRequestURL(), sb.toString());
			return false;
		}
	}
}