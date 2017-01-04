package com.yancey.manager.service.impl;

import org.springframework.stereotype.Service;

import com.yancey.manager.service.HessianService;

@Service("hessianServiceImpl")
public class HessianServiceImpl implements HessianService {

	@Override
	public String sayHello(String name) {
		return "hello " +name;
	}

	@Override
	public String sayWorld(String name) {
		return "world" +name ;
	}

	@Override
	public String sayHello(int age) {
		// TODO Auto-generated method stub
		return age+"";
	}

}
