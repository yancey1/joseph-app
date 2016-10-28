package com.yancey.manager.service;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;

import com.yancey.manager.bto.VipListBto;

public interface IVipService {

	public VipListBto getVipList(CloseableHttpClient client);
}
