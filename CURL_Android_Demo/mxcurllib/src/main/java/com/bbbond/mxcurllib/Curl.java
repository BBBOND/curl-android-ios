package com.bbbond.mxcurllib;

import android.util.Log;

import com.bbbond.mxcurllib.easy.MultiPart;

import java.util.List;

/**
 * Curl Jni Wrapper</br>
 * <p>
 * Usage: See MainActivity in demo project<br/>
 * <p>
 * <p>
 * Curl object isn't thread safe, DO NOT share one Curl instant through multiple threads.
 *
 * @see http://curl.haxx.se/libcurl/c/
 */
public class Curl {

  private static final String TAG = Curl.class.getSimpleName();

  private long handle;
  private static boolean INIT = false;

  static {
    System.loadLibrary("mxcurl");
  }

  private native static String curlGetVersion();

  private native static int curlGlobalInitNative(int flags);

  private native static void curlGlobalCleanupNative();

  private native long curlEasyInitNative();

  private native void curlEasyCleanupNative(long handle);

  private native int curlEasySetoptLongNative(long handle, int opt, long value);

  private native int curlEasySetoptFunctionNative(long handle, int opt, Callback callback);

  private native int curlEasySetoptObjectPointNative(long handle, int opt, String value);

  private native int curlEasySetoptObjectPointBytesNative(long handle, int opt, byte[] value);

  private native int curlEasySetoptObjectPointArrayNative(long handle, int opt, String[] value);

  private native int setFormdataNative(long handle, MultiPart[] multiArray);

  private native int curlEasyPerformNavite(long handle);

  public interface Callback {
  }

  private static Object CLEANUP = new Object() {
    @Override
    protected void finalize() throws Throwable {
      if (INIT) {
        Log.i(TAG, "curlGlobalCleanup");
        curlGlobalCleanupNative();
      }
    }

  };


  public String curlVersion() {
    return curlGetVersion();
  }


  public interface WriteCallback extends Callback {
    /**
     * Called when data received from peer (for example: header, body)
     *
     * @param data
     * @return the number of bytes actually taken care of.
     * @see http://curl.haxx.se/libcurl/c/CURLOPT_WRITEFUNCTION.html
     */
    public int readData(byte[] data);
  }

  public interface ReadCallback extends Callback {
    /**
     * Called when data need send to peer (for example: header, form)
     *
     * @param data the buffer to fill
     * @return the actual number of bytes that it stored in that memory area.
     * @see http://curl.haxx.se/libcurl/c/CURLOPT_READFUNCTION.html
     */
    public int writeData(byte[] data);
  }


  public Curl() {
    if (!INIT) {
      curlGlobalInit(CurlConstant.CURL_GLOBAL_DEFAULT);
    }
  }

  public static void curlGlobalInit(int flags) {
    if (INIT) {
      return;
    }

    CurlCode code = CurlCode.fromValue(curlGlobalInitNative(flags));
    if (code != CurlCode.CURLE_OK) {
      throw new IllegalStateException("curlGlobalInit fail: " + code);
    }
    INIT = true;
  }

  public void curlEasyInit() throws CurlException {
//    Log.v(TAG, "curlEastInit");
    handle = curlEasyInitNative();
    if (handle == 0) {
      throw new CurlException("curl init native fail");
    }
  }

  public void curlEasyCleanup() {
    Log.v(TAG, "curlEastCleanup: " + handle);
    if (handle != 0) {
      curlEasyCleanupNative(handle);
    }
    handle = 0;
  }

  /**
   * @param opt   {@link CurlOpt.OptLong}
   * @param value
   * @return
   */
  public CurlCode curlEasySetopt(CurlOpt.OptLong opt, long value) {
//    Log.v(TAG, "curlEastSetopt: " + opt + "=" + value);
    return CurlCode.fromValue(curlEasySetoptLongNative(handle, opt.getValue(), value));
  }

  public CurlCode curlEasySetopt(CurlOpt.OptFunctionPoint opt, WriteCallback callback) {
//    Log.v(TAG, "curlEastSetopt: " + opt + "=" + callback);
    return CurlCode.fromValue(curlEasySetoptFunctionNative(handle, opt.getValue(), callback));
  }

  public CurlCode curlEasySetopt(CurlOpt.OptObjectPoint opt, String value) {
//    Log.v(TAG, "curlEastSetopt: " + opt + "=" + value);
    return CurlCode.fromValue(curlEasySetoptObjectPointNative(handle, opt.getValue(), value));
  }

  public CurlCode curlEasySetopt(CurlOpt.OptObjectPoint opt, byte[] value) {
//    Log.v(TAG, "curlEastSetopt: " + opt + "=" + value);
    return CurlCode.fromValue(curlEasySetoptObjectPointBytesNative(handle, opt.getValue(), value));
  }

  public CurlCode curlEasySetopt(CurlOpt.OptObjectPoint opt, String[] values) {
//    Log.v(TAG, "curlEastSetopt: " + opt + "=" + values);
    return CurlCode.fromValue(curlEasySetoptObjectPointArrayNative(handle, opt.getValue(), values));
  }

  /**
   * if set multiple times, previous form will be cleared!
   *
   * @param multiParts
   * @return
   */
  public CurlFormCode setFormdata(List<MultiPart> multiParts) {
    if (multiParts != null && multiParts.size() > 0) {
      return CurlFormCode.fromValue(setFormdataNative(handle, multiParts.toArray(new MultiPart[multiParts.size()])));
    } else {
      return CurlFormCode.CURL_FORMADD_NULL;
    }
  }

  public CurlCode curlEasyPerform() {
//    Log.v(TAG, "curlEasyPerform");
    return CurlCode.fromValue(curlEasyPerformNavite(handle));
  }
}
