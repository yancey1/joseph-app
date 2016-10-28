package com.yancey.manager.util;

public class ReturnJsonCode {

  public static final String RETURN_CODE = "code";
  public static final String RETURN_MSG  = "message";
  public static final String RETURN_DATA  = "data";

  public enum MsgCodeEnum {
    SUCCESS(1, "操作成功！"),
    FAILURE(0, "操作失败！"),
    INFO_EXISTS(2, "信息已存在！"),
    UPLOAD_TYPE(3, "上传文件类型不匹配"),
    BEEN_APPLIED(4, "记录已被引用，不能删除！"),
    AUTHORITY(5, "没有权限！"),
    APK_ON_LINE(6, "有相同包名的应用已上线,请先将其下线！"),
    APPNAME_EXISTS(7, "业务名称已存在！"),
    IMAGEERROR(8, "图片格式不对！"),
    ERRORPARAM(9, "参数错误！"),
    ILLEGALCLIENT(10, "非空客户端！"),
    ERRORSIGN(11, "签名错误！");

    private int    code;
    private String msg;

    MsgCodeEnum(int _code, String _msg) {
      this.code = _code;
      this.msg = _msg;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getMsg() {
      return msg;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

  }

}
