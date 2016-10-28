package com.yancey.manager.domain;

public class UserMarket {

  private Integer userId;
  private String  marketId;
  private Integer pindaoId;

  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getMarketId() {
    return marketId;
  }
  public void setMarketId(String marketId) {
    this.marketId = marketId;
  }
  public Integer getPindaoId() {
    return pindaoId;
  }
  public void setPindaoId(Integer pindaoId) {
    this.pindaoId = pindaoId;
  }

}
