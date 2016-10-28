package com.yancey.manager.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author wangcb
 * 
 */
public class UUIDUtils {

  public static synchronized String getUUID() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public static synchronized String getRandomString(int length) {
    if (length <= 0) {
      return "";
    }
    char[] randomChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h',
        'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
    Random random = new Random();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < length; i++) {
      stringBuffer.append(randomChar[Math.abs(random.nextInt()) % randomChar.length]);
    }
    return stringBuffer.toString();
  }

}