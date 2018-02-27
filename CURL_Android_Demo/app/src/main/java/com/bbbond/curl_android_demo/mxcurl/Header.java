package com.bbbond.curl_android_demo.mxcurl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bbbond on 2018/2/27.
 */

public class Header {

  private HashMap<String, String> header = new HashMap<>();

  public Header() {

  }

  public Header(String headerStr) {
    if (!"".equals(headerStr)) {
      String[] headerList = headerStr.split("\r\n");
      for (String h : headerList) {
        String key = getKey(h);
        String value = getValue(h);
        if (key != null && value != null) {
          header.put(key, value);
        }
      }
    }
  }

  private String getKey(String headerStr) {
    if (headerStr.contains(":")) {
      return headerStr.split(": ")[0];
    }
    return null;
  }

  private String getValue(String headerStr) {
    if (headerStr.contains(":")) {
      return headerStr.split(": ")[1];
    }
    return null;
  }

  public void add(String key, String value) {
    if (header.containsKey(key)) {
      header.put(key, header.get(key) + ";" + value);
    } else {
      header.put(key, value);
    }
  }

  public String get(String key) {
    return header.get(key);
  }

  public String[] toHeaderString() {
    List<String> headerList = new ArrayList<>();
    for (String key : header.keySet()) {
      headerList.add(key + ": " + header.get(key));
    }
    return headerList.toArray(new String[headerList.size()]);
  }

  @Override
  public String toString() {
    return header.toString();
  }
}
