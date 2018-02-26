package com.bbbond.curl_android_demo.utils;

/**
 * Created by bbbond on 2018/2/24.
 */

public class CurlUtils {
  static {
    System.loadLibrary("mxcurl");
  }

  public static native byte[] get(String url);

  public static native byte[] post(String url);

}
