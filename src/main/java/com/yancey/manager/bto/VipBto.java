package com.yancey.manager.bto;

import com.yancey.manager.domain.BaseDomain;

public class VipBto extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -662782591914230361L;

	private String accountName;
	
	private String password;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
