package com.yancey.manager.bto;

import java.util.List;

import com.yancey.manager.domain.BaseDomain;

public class VipListBto extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1931784523021485945L;

	private List<VipBto> youKuList;
	
	private List<VipBto> aiQiYiList;
	
	private List<VipBto> xunLeiList;
	
	private List<VipBto> leShiList;
	
	private List<VipBto> tuDouList;

	public List<VipBto> getYouKuList() {
		return youKuList;
	}

	public void setYouKuList(List<VipBto> youKuList) {
		this.youKuList = youKuList;
	}

	public List<VipBto> getAiQiYiList() {
		return aiQiYiList;
	}

	public void setAiQiYiList(List<VipBto> aiQiYiList) {
		this.aiQiYiList = aiQiYiList;
	}

	public List<VipBto> getLeShiList() {
		return leShiList;
	}

	public void setLeShiList(List<VipBto> leShiList) {
		this.leShiList = leShiList;
	}

	public List<VipBto> getTuDouList() {
		return tuDouList;
	}

	public void setTuDouList(List<VipBto> tuDouList) {
		this.tuDouList = tuDouList;
	}

	public List<VipBto> getXunLeiList() {
		return xunLeiList;
	}

	public void setXunLeiList(List<VipBto> xunLeiList) {
		this.xunLeiList = xunLeiList;
	}

}
