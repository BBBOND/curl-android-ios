package com.bbbond.curl_android_demo.mxcurl;

/**
 * Created by bbbond on 2018/2/27.
 */

public class Response {
  private Header header;
  private ResponseBody body;
  private int code;

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }

  public ResponseBody getBody() {
    return body;
  }

  public void setBody(ResponseBody body) {
    this.body = body;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
