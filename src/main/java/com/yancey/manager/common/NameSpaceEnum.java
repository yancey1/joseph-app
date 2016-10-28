package com.yancey.manager.common;

/**
 * 命名空间枚举类
 * 
 * */
public enum NameSpaceEnum {

  JOKEINFO("slh_joke", "段子管理"),
  WEATHER("slh_weather", "天气管理"),
  IMAGE("slh_image", "图片管理"),
  WALLPAPER("slh_wallpaper", "壁纸管理"),
  LOCKTYPE("slh_locktype", "锁屏类型"),
  WALLPAPERIMAGE("slh_wallpaper_image", "壁纸图片管理"),
  CONSULT("slh_consult", "资讯信息管理"),
  CONSULTREF("slh_consult_ref", "资讯内容关联管理"),
  STATISTICS("slh_statistics","启动应用留存"),
  SUMSTATISTICS("slh_statistics_sum","启动应用留存和"),
  TYPEDATA("slh_type_data","类型PV/UV"),
  PLAYGAMEDATA("slh_play_game_data","游戏PV/UV"),
  LEFTSLIPDATA("slh_left_slip_data","左划PV/UV"),
  LOCKSCREEN("slh_lockscreen","锁屏部署管理"),
  LOCKSCREENSWITCH("slh_lockScreenSwitch","锁屏状态管理"),
  LOCKSCREENREF("slh_lockscreenRef","锁屏部署映射"),
  PUSHTHEME("slh_pushtheme","推送主题"),
  PROVINCE("slh_province","省份"),
  CITY("slh_city","城市"),
  NEWSINFO("slh_news_info","热点"),
  APKUPDATE("slh_apkupdateinfo", "自更新管理"),
  STOREACCOUNT("slh_store_account", "门店账号信息"),
  GROUP("slh_group", "组管理"),
  GROUPSTORE("slh_group_store", "组门店关联表"),
  GROUPAPK("slh_group_apk", "组应用关联表"),
  CARTOON("slh_cartoon", "漫画表") ,
  GAMEDATA("slh_game_data", "游戏表") ,
  REMAINDATA("slh_remain", "留存表") ,
  REMAINSUMDATA("slh_remain_sum", "留存求和表"),
  TOTALDATA("slh_total_data", "总体数据表"),
  TYPEPVUVDATA("slh_type_pvuv_data", "类型pvuv数据表"),
  VERSIONDATA("slh_version_data", "版本新增数据表"),
  VERSIONUVDATA("slh_version_uv_data", "版本uv表"),
  ASSEMBLYAPK("slh_assembly_apk_mapping","组件信息管理"),
  ASSEMBLY("slh_assembly","组件信息管理"),
  CLASSIFYASSEMBLY("slh_classify_assembly","分类组件信息关联表"),
  GROUPASSEMBLY("slh_group_assembly", "组组件关联表"),
  PAGEGAME("slh_page_game", "夜游数据表"),
  PAGEGAMECLASSIFY("slh_page_game_classify", "分类数据表"),
  PAGEGAMECLASSIFYMAPP("slh_page_game_classify_mapp", "游戏分类关联表"),
  REFCOMMENT("slh_ref_comment_mapp", "评分关联表"),
  ADVER("slh_adver", "公告关联表"),
  TOPIC("slh_topic", "栏目管理"),
  TOPICINFO("slh_topic_info", "栏目"),
  RECOMMEND("slh_recommend", "推荐管理"),
  HOTWORD("slh_hotWord", "热词管理"),
  HOTSEARCHPAR("slh_hotSearchPar", "热门搜索管理"),
  PAGEGAMEDEPLOY("slh_page_game_deploy","页游部署表"),
  RANK("slh_ranking","排行榜表"),
  APKDOWNLOADDATA("slh_apk_down_load_data", "端游表") ,
  PAGEGAMEDATA("slh_page_game_data", "页游表") ,
  BIZAPP("slh_biz_app", "业务表") ,
  BIZAPPMAPPING("slh_biz_app_mapping", "业务栏目表") ,
  COMMENT("slh_comment","评论管理"),
  CHOOSELIKEDATA("slh_choose_like_data", "选你喜欢表"),
  APKDATA("slh_apk_data", "端游表"),
  GAMENAVDATA("slh_game_nav_data", "游戏导航表"),
  PAGEGAMEPVUVDATA("slh_page_game_pvuv_data", "页游pvuv表"),
  LOCKSCREENPVUVDATA("slh_lock_screen_pvuv_data", "锁屏开关pvuv表"),
  SEARCHPVUVDATA("slh_search_pvuv_data", "搜索pvuv表"),
  COLLECTIONDATA("slh_collection_data", "收藏表"),
  JOKEDATA("slh_joke_data", "段子表"),
  NEWSDATA("slh_news_data", "热点表"),
  CARTOONDATA("slh_cartoon_data", "漫画表"),
  WALLPAPERPVUVDATA("slh_wall_paper_pvuv_data", "壁纸子分类表"),
  WALLPAPERDATA("slh_wall_paper_data", "壁纸表"),
  INFOR("slh_infor", "资讯表"),
  WINRECORD("slh_win_record", "中奖记录表"),
  ACTIVITY("slh_activity", "活动表"),
  ACTIVITYOPERATE("slh_activity_operate", "活动运营语信息表"),
  LOTTERYDRAWACTIVITY("slh_lottery_draw_activity", "活动表"),
  ACTIVITYMAPP("slh_activity_mapping", "活动映射表"),
  BIZACTIVITYMAPP("slh_biz_activity_mapping", "业务活动映射表"),
  LOTTERYDRAWACTIVITYMAPP("slh_lottery_draw_activity_prize_mapp", "活动奖品映射表"),
  PRIZE("slh_prize", "奖品信息表"),
  STRATEGY("slh_strategy", "攻略信息表"),
  STRATEGYCOMMENT("slh_strategy_comment", "攻略评论信息表"),
  LOGINDATA("slh_login_data", "登陆数据表"),
  REGISTERDATA("slh_register_data", "登陆数据表"),
  INFORDATA("slh_infor_data", "资讯数据表"),
  INTERACTDATA("slh_interact_data", "栏目互动数据表"),
  ACTIVITYTDATA("slh_activity_data", "活动参与数据表"),
  INCOMETDATA("slh_income_data", "收入明细数据表"),
  PAYDATA("slh_pay_data", "支出明细数据表"),
  BALANCEDATA("slh_balance_data", "收支明细数据表"),
  STRATEGYDATA("slh_strategy_data", "攻略数据表"),
  APK("slh_apk","APK"),
  BANNER("slh_banner", "banner管理表"),
  CLASSIFY("slh_classify", "分类管理表");
  
  private String nameSpace;
  private String desc;

  private NameSpaceEnum(String nameSpace, String desc) {
    this.nameSpace = nameSpace;
    this.desc = desc;
  }

  public String getNameSpace() {
    return nameSpace;
  }

  public void setNameSpace(String nameSpace) {
    this.nameSpace = nameSpace;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}
