package com.bbbond.mxcurllib.util;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CaseInsensitiveMap<K, V> extends HashMap {

  private static final long serialVersionUID = -3480280688459075349L;

  @SuppressLint("DefaultLocale")
  private Object normalizeKey(Object key) {
    if (key != null && key instanceof String) {
      return ((String) key).toLowerCase();
    }
    return key;
  }

  @Override
  public Object put(Object key, Object value) {
    return super.put(normalizeKey(key), value);
  }

  @Override
  public void putAll(Map map) {
    for (Object entry : map.entrySet()) {
      Entry<Object, Object> e = (Entry<Object, Object>) entry;
      put(e.getKey(), e.getValue());
    }
  }

  @Override
  public Object get(Object key) {
    return super.get(normalizeKey(key));
  }
}
