package com.bbbond.curl_android_demo.mxcurl.internal;

import com.bbbond.curl_android_demo.mxcurl.Response;

import java.io.IOException;

/**
 * Created by bbbond on 2018/2/24.
 */

public class CurlUtils {
  static {
    System.loadLibrary("mxcurl");
  }

  public static native Response get(String url, String[] header) throws IOException;

  public static native Response post(String url, String params, String[] header) throws IOException;

}
