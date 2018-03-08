package com.bbbond.mxcurllib;

import android.util.SparseArray;

/**
 * Created by bbbond on 2018/3/1.
 */

public enum CurlFormCode {
  CURL_FORMADD_OK(0), //
  CURL_FORMADD_MEMORY(1), //
  CURL_FORMADD_OPTION_TWICE(2), //
  CURL_FORMADD_NULL(3), //
  CURL_FORMADD_UNKNOWN_OPTION(4), //
  CURL_FORMADD_INCOMPLETE(5), //
  CURL_FORMADD_ILLEGAL_ARRAY(6), //
  CURL_FORMADD_DISABLED(7), //
  ;

  private final int value;

  private static SparseArray<CurlFormCode> valuesMap = new SparseArray<CurlFormCode>();

  static {
    for (CurlFormCode e : values()) {
      valuesMap.put(e.getValue(), e);
    }
  }

  private CurlFormCode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static CurlFormCode fromValue(int value) {
    return valuesMap.get(value);
  }
}
