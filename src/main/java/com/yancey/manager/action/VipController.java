package com.yancey.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yancey.manager.bto.VipListBto;
import com.yancey.manager.service.IVipService;
import com.yancey.manager.util.ResponseUtils;
import com.yancey.manager.util.ReturnJsonCode;

@RequestMapping("/vip")
@Controller
public class VipController {

	private static final Logger logger = LoggerFactory.getLogger(VipController.class);

	@Autowired
	IVipService vipService;

	@RequestMapping(value = "getVipDataList", method = RequestMethod.GET)
	public void getVipDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			CloseableHttpClient httpClient = getHttpClient(request);
			VipListBto vipList = vipService.getVipList(httpClient);
			ResponseUtils.responseSuccess(response, vipList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ResponseUtils.responseError(response, ReturnJsonCode.MsgCodeEnum.FAILURE.getMsg());
		}

	}

	public CloseableHttpClient getHttpClient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CloseableHttpClient httpClient = (CloseableHttpClient) session.getAttribute("client");
		if (httpClient == null) {
			HttpClientBuilder clientBuilder = HttpClientBuilder.create();
			RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000).setStaleConnectionCheckEnabled(true).build();
			clientBuilder.setDefaultRequestConfig(defaultRequestConfig);
			httpClient = clientBuilder.build();
		}
		return httpClient;
	}
}
