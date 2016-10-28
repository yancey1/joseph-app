package com.yancey.manager.domain;


public enum UserEnum {
	DELETE(1, "已发送"), SAVE(0, "slh_user.insert_slh_user");

	private int type;

	private String statementName;

	private UserEnum(int type, String statementName){
		this.type = type;
		this.statementName = statementName;
	}
	public static UserEnum getChannelActiveEnum(int type) {
		for (UserEnum channelActiveEnum : UserEnum.values()) {
			if (channelActiveEnum.getType() == type) {
				return channelActiveEnum;
			}
		}
		return null;
	}

	public int getType() {
		return type;
	}
	public String getStatementName() {
		return statementName;
	}
	public void setType(int type) {
		this.type = type;
	}

}
