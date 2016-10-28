package com.yancey.manager.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;

import com.yancey.manager.domain.User;
import com.yancey.manager.util.DateUtils;
import com.yancey.manager.util.UUIDUtils;

public class ConstantsCMP {

  public final static String                              MESSAGE           = "message";
  public final static String                              USER_SESSION_INFO = "userSessionInfo";

  private static final String                             APK_FOLDER        = "/apk/";
  private static final String                             APK_UPDATE_FOLDER = "/apkupdate/";
  private static final String                             IMG_FOLDER        = "/img/";
  private static final String                             HTM_FOLDER        = "/htm/";
  public static final Integer                             stopStatus        = -1;

  public static final Integer                             RESOURCE_TYPE     = 1;

  public static final String                              ADMIN             = "admin";
  public static Map<Integer, String>                      marketPindaoMap   = new HashMap<Integer, String>();

  private static final int                                minNum            = 0;
  private static final int                                maxValue          = 10000;
  private static final String                             numKey            = "imageKey";
  public static final Integer                             initScore         = 3;
  public static final String                              underLine         = "_";
  public static final Integer                            down=2;  
  private static ConcurrentHashMap<String, AtomicInteger> numAtomicMap      = new ConcurrentHashMap<String, AtomicInteger>();
  static {
    marketPindaoMap.put(1, "推荐");
    marketPindaoMap.put(2, "逛逛");
    marketPindaoMap.put(3, "我的");
  }

  public static User getSessionUser(HttpServletRequest request) {
    return (User) (request.getSession().getAttribute(ConstantsCMP.USER_SESSION_INFO));
  }

  /**
   * 获取图片存储相对路径 (/img/2013/09/16/uuid/ato)
   */
  public static String getImgRelativePath() {
    /*
     * StringBuffer sb = new StringBuffer();
     * sb.append(IMG_FOLDER).append(DateUtils
     * .getCurrentDateFilePath()).append("/"); return sb.toString();
     */

    AtomicInteger num = numAtomicMap.get(numKey);
    if (num == null) {
      num = new AtomicInteger(minNum);
      numAtomicMap.put(numKey, num);
    }
    if (num.get() >= maxValue) {
      num.set(minNum);
    }
    StringBuffer sb = new StringBuffer();
    sb.append(IMG_FOLDER).append(DateUtils.getCurrentDateFilePath()).append("/").append(UUIDUtils.getRandomString(10)).append(num.incrementAndGet());
    return sb.toString();
  }

  /**
   * 获取图片生成的名称 (uuid/ato)
   */
  public static String getImgName() {
    AtomicInteger num = numAtomicMap.get(numKey);
    if (num == null) {
      num = new AtomicInteger(minNum);
      numAtomicMap.put(numKey, num);
    }
    if (num.get() >= maxValue) {
      num.set(minNum);
    }
    StringBuffer sb = new StringBuffer();
    sb.append(UUIDUtils.getRandomString(10)).append(num.incrementAndGet());
    return sb.toString();
  }

  /**
   * 获取应用存储相对路径 (/apk/2013/09/16/uuid/)
   */
  public static String getApkRelativePath() {
    StringBuffer sb = new StringBuffer();
    sb.append(APK_FOLDER).append(DateUtils.getCurrentDateFilePath()).append("/").append(UUIDUtils.getRandomString(10)).append("/");
    return sb.toString();
  }

  /**
   * 获取自更新应用存储相对路径 (/apk/2013/09/16/uuid/)
   */
  public static String getApkUpdateRelativePath() {
    StringBuffer sb = new StringBuffer();
    sb.append(APK_UPDATE_FOLDER).append(DateUtils.getCurrentDateFilePath()).append("/").append(UUIDUtils.getRandomString(10)).append("/");
    return sb.toString();
  }

  /**
   * 获取html存储相对路径 (/htm/2013/09/16/uuid/ato)
   */
  public static String getHtmlRelativePath() {
    AtomicInteger num = numAtomicMap.get(numKey);
    if (num == null) {
      num = new AtomicInteger(minNum);
      numAtomicMap.put(numKey, num);
    }
    if (num.get() >= maxValue) {
      num.set(minNum);
    }
    StringBuffer sb = new StringBuffer();
    sb.append(HTM_FOLDER).append(DateUtils.getCurrentDateFilePath()).append("/").append(UUIDUtils.getRandomString(10)).append(num.incrementAndGet());
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(getApkUpdateRelativePath());
  }

  /**
   * 图片类型
   */
  public static Map<String, String> getImageTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("0", "壁纸"); // 480x214
    map.put("1", "天气");
    map.put("31", "用户图像");
    return map;
  }

  /**
   * 栏目类型
   */
  public static Map<String, String> getTopicMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "热点"); // 480x214
    map.put("2", "段子");
    map.put("4", "游戏");
    map.put("5", "漫画");
    map.put("6", "壁纸");
    return map;
  }
  /**
   * 推荐类型
   */
  public static Map<String, String> getRecommendTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "页游");
    map.put("2", "端游");
    map=sortMapByKey(map);
    return map;
  }
  /**
   * 推荐展现机制
   */
  public static Map<String, String> getRecommendDisplay() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "随机");
    map.put("2", "轮播");
    return map;
  }

  /**
   * 评论资源类型管理
   */
  public static Map<String, String> getCommentTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "页游"); // 480x214
    map.put("2", "端游");
    map=sortMapByKey(map);
    return map;
  }

  public static Map<String, String> sortMapByKey(Map<String, String> map) {
    if (map == null || map.isEmpty()) {
      return null;
    }
    Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
    sortMap.putAll(map);
    return sortMap;
  }

  /**
   * 展现机制类型
   */
  public static Map<String, String> getDisplayTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "立即生效");
    map.put("2", "指定时间点");
    map.put("4", "指定时间段");
    return map;
  }

  /**
   * 统计或者不统计
   */
  public static Map<String, String> getTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "统计");
    map.put("0", "不统计");
    return map;
  }

  /**
   * 组件类型
   */
  public static Map<String, String> getAssemblyTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "常规");
    return map;
  }
  /**
   * 
   */
  public static Map<String, String> getActivityRefTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "抽奖");
    map.put("2", "抢红包");
    return map;
  }
  /**
   * 奖品状态
   * 待处理，2-已发放，3-处理失败
   */
  public static Map<String, String> getWinRecordStateMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "待处理");
    map.put("2", "已发放");
    map.put("3", "处理失败");
    return map;
  }
  /**
   * 活动状态
   */
  public static Map<String, String> getActivityStateMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("1", "上线");
    map.put("0", "下线");
    return map;
  }
  /**
   * 活动状态
   */
  public static Map<String, String> getActivityTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
   /* map.put("1", "跳链接");*/
    map.put("2", "跳抽奖页面");
    return map;
  }
  
  /**
   * 奖品类型
   */
  public static Map<String, String> getPrizeTypeMap() {
    Map<String, String> map = new HashMap<String, String>();
    //0-谢谢惠顾，1-积分，2-话费，3-流量，4-吉木吉祥物,5-其它
    map.put("0", "谢谢惠顾"); // 480x214
    map.put("1", "积分");
    map.put("2", "话费");
    map.put("3", "流量");
/*    map.put("4", "吉木吉祥物");
    map.put("5", "其它");*/
    return map;
  }

  /**
   * 1:apk 2:栏目 3:wap
   */
  public final static int    ASSEMBLY_RESOURCE_TYPE_APK    = 1;
  public final static int    ASSEMBLY_RESOURCE_TYPE_TOPIC  = 2;
  public final static int    ASSEMBLY_RESOURCE_TYPE_WAP    = 3;

  /**
   * 0:不立即下载 1:立即下载
   */
  public final static int    ASSEMBLY_APK_DOWNLOAD_NOW_NO  = 0;
  public final static int    ASSEMBLY_APK_DOWNLOAD_NOW_YES = 1;

  /**
   * 应用状态:-1下线；1上线
   */
  public final static int    APK_STATUS_DELETE             = 0;
  public final static int    APK_STATUS_HIGHLINE           = 1;
  public final static int    APK_STATUS_DOWNLINE           = -1;

  /**
   * 区分查全部应用还是查私有应用
   */
  public final static int    APK_FLAG_ALL                  = 0;
  public final static int    APK_FALG_PRIVATE              = 1;

  public final static String TYD_TYPE                      = "tyd000";

  /**
   * 区分是查天奕达的全部应用还是查合作商的全部应用
   */
  public final static int    APK_CTYPE_TYD                 = 1;
  public final static int    APK_CTYPE_OTHER               = 0;

  /**
   * 区分上传应用公司类型
   */
  public final static int    COMPANY_TYPE_THIRD_PART       = 0;                          // 第三方
  public final static int    COMPANY_TYPE_TYD              = 1;                          // 天奕达
  public final static int    COMPANY_TYPE_PARTNER          = 2;                          // 合作商

  /**
   * 1:wifi 2:2G 3:全部
   */
  public final static int    SILENTDOWNLOAD_TYPE_WIFI      = 1;
  public final static int    SILENTDOWNLOAD_TYPE_2G        = 2;
  public final static int    SILENTDOWNLOAD_TYPE_ALL       = 3;

  public static final int    OPERATE_SUCCESS               = 1;
  public static final int    OPERATE_FAILD                 = -1;
  public static final String POINT                         = ".";

  /**
   * isdown 1：正常 2：下架
   */
  public final static int    PAGEGAME_ISDOWN_HIGHLINE      = 1;
  public final static int    PAGEGAME_ISDOWN_DOWNLINE      = 2;

  public static final String templatePrefix                = "<!doctype html><html><head>"
                                                               + "<meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0\"><meta name=\"keywords\" content=\"test\" /><meta name=\"description\" content=\"\" />"
                                                               + "<title>test</title><link rel=\"stylesheet\" type=\"text/css\" href=\"style/css/mobile.css\" /><style>body,button,dd,dl,dt,fieldset,form,h1,h2,h3,h4,h5,h6,input,legend,li,ol,p,select,table,td,textarea,th,ul {margin: 0;padding: 0}body {"
                                                               + "min-width: 320px;font-family: 'microsoft yahei',Verdana,Arial,Helvetica,sans-serif;color: #333;-webkit-text-size-adjust: none}fieldset,img {border: 0}ol,ul {list-style: none}address,em {font-style: normal}"
                                                               + "a {color: #000;text-decoration: none}table {border-collapse: collapse}#clear {clear: both;width: 100%;background-color: #fff}#clear: after {display: block;clear: both;height: 1px;content: ''}img, fieldset {border: 0;}"
                                                               + "img {height: auto;width: auto/9;width:100%;}.shop-title {padding:10px 0;}.shop-list {}.shop-list li {text-align:center;padding:20px 0;}.shop-list li p {text-align:left;color:#7A7878; text-indent:2em;}.shop-list li img {margin:0 auto;}"
                                                               + "</style></head><body>";

  public static final String templateSuffix                = "</body><html>";
}
