package com.bbbond.curl_android_demo.mxcurl;

/**
 * Created by bbbond on 2018/2/27.
 */

public class ResponseBody {
  private String data;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return data;
  }
}
