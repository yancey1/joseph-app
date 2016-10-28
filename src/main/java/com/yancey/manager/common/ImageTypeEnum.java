package com.yancey.manager.common;

/**
 * 图片类型枚举类
 * 
 * */
public enum ImageTypeEnum {

  WALLPAPERIMAGE(0, "壁纸", 720, 1280) , 
  WEATHERIMAGE(1, "天气", 128, 128),
  NEWSIMAGE(2, "热点", 0, 0), 
  JOKEIMAGE(3, "段子", 720, 0),
  BIGWALLPAPERIMAGE(4, "大壁纸", 720, 1280) , 
  SMALLIWALLPAPERMAGE(5, "小壁纸", 240, 426),
  BIGINEWSMAGE(6, "大图热点", 692, 520), 
  SMALLNEWSIMAGE(7, "小图热点", 173, 130),
  BIGSCREEN(8, "大锁屏", 720, 1280) , 
  SMALLISCREEN(9, "小锁屏", 240, 426),
  LOCKSCREENIMAGE(10, "热点", 160, 160),
  CARTOONIMAGE(11, "漫画", 720,0),
  APKIMAGE(12, "apk图标",96,96),
  PAGEGAMEIMAGE(13, "页游图标",96,96),
  PAGEGAMECLASSIFY(14, "分类", 96, 96),
  ANNOUNCEIMAGE(2, "公告图片",96,96),
  APKSCREENSHOT(15, "端游截图",480,800),
  STRATEGYSCREENSHOT(15, "端游截图",480,800),
  PAGEGAMESCREENSHOT(16, "页游截图",480,800),
  ICON(17, "页游图标",480,800),
  ACTIVITYIMAGE(18, "活动", 720, 0),
  PRIZESMALLIMAGE(19, "奖品信息", 720, 0),
  PRIZEBIGIMAGE(20, "奖品信息", 720, 0),
  INFORIMAGE(21, "资讯", 720, 0),
  STRATEGYIMAGE(22, "攻略", 720, 0),
  USERIMAGE(31, "用户图像", 128, 128),
  BANNERIMAGE(50, "BANNER图片", 128, 38),
  TRATEGYIMAGEMapping(24, "攻略截图", 720, 0);

  private Integer type;
  private String  name;
  private Integer width;
  private Integer height;

 private ImageTypeEnum(Integer type, String name,Integer width,Integer height) {
    this.type = type;
    this.name = name;
    this.width=width;
    this.height=height;
  }

  public static Integer getWidth(Integer type){
    int width=0;
    for (ImageTypeEnum obj : ImageTypeEnum.values()) {
      if(type.equals(obj.getType())){
        width=obj.getWidth();
      }
    }
    return width;
  }
  
  public static Integer getHeight(Integer type){
    int height=0;
    for (ImageTypeEnum obj : ImageTypeEnum.values()) {
      if(type.equals(obj.getType())){
        height=obj.getHeight();
      }
    }
    return height;
  }
  
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
