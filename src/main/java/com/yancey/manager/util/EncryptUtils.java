package com.yancey.manager.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.joyreach.apk.utils.MD5Checksum;

import edu.hziee.cap.common.util.Md5Utils;

import sun.misc.BASE64Encoder;

public class EncryptUtils {
  public static final String encryptMD5(String source) {
    if (source == null) {
      source = "";
    }
    Sha256Hash hash = new Sha256Hash(source);
    return new Md5Hash(hash).toString();
  }

  public static void main(String[] args) {
	  System.out.println(Md5Utils.getMd5("http://192.168.1.98/2/Debug-10.zip"));
	  try {
		System.out.println(MD5Checksum.getMD5Checksum("D:\\Debug.zip"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
