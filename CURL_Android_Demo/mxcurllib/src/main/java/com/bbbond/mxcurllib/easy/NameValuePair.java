package com.bbbond.mxcurllib.easy;

public class NameValuePair {

  private final String name;
  private final String value;


  public NameValuePair(String name, String value) {
    super();
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  /**
   * @return "" if null value
   */
  public String getValue() {
    if (value == null) {
      return "";
    }
    return value;
  }
}
