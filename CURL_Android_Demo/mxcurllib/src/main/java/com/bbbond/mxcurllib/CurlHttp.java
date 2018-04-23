package com.bbbond.mxcurllib;

import android.util.Log;

import com.bbbond.mxcurllib.CurlOpt.OptFunctionPoint;
import com.bbbond.mxcurllib.CurlOpt.OptLong;
import com.bbbond.mxcurllib.CurlOpt.OptObjectPoint;
import com.bbbond.mxcurllib.easy.MultiPart;
import com.bbbond.mxcurllib.easy.NameValuePair;
import com.bbbond.mxcurllib.util.CaseInsensitiveMap;
import com.bbbond.mxcurllib.util.Logger;
import com.bbbond.mxcurllib.util.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurlHttp {

  private static final String TAG = CurlHttp.class.getSimpleName();

  private static final Logger logger = Logger.getLogger(CurlHttp.class);

  private Curl curl;
  private Map<String, String> headerMap;
  private List<MultiPart> multiPartList;
  private List<NameValuePair> simplePairList;
  private byte[] body;
  private String requestMethod;
  private boolean followLocation = true;
  private int maxRedirects = 3;
  private boolean useSystemProxy = true;
  private String proxyHost;
  private int proxyPort;
  private boolean asMultipart = false;
  private String url;

  private CurlHttp() {
    curl = new Curl();
  }

  @Override
  protected void finalize() throws Throwable {
    if (curl != null)
      curl.curlEasyCleanup();
    super.finalize();
  }

  public static CurlHttp newInstance() throws Exception {
    CurlHttp curlEasy = new CurlHttp();
    curlEasy.curl.curlEasyInit();
    curlEasy.headerMap = new HashMap<String, String>();
    curlEasy.headerMap.put("User-Agent", "curlcore/" + curlEasy.curl.curlVersion() + " " + Constant.LIB_NAME + "/" + Constant.LIB_VERSION);
    return curlEasy;
  }

  /**
   * @param name
   * @param value pass a null value clear previous set(or curl default) header
   * @return
   */
  public CurlHttp addHeader(String name, String value) {
    headerMap.put(name, value);
    return this;
  }

  public CurlHttp setConnectionTimeoutMillis(long millis) {
    curl.curlEasySetopt(OptLong.CURLOPT_CONNECTTIMEOUT_MS, millis);
    return this;
  }

  public CurlHttp setTimeoutMillis(long millis) {
    curl.curlEasySetopt(OptLong.CURLOPT_TIMEOUT_MS, millis);
    return this;
  }

  public CurlHttp setIpResolveV4() {
    curl.curlEasySetopt(OptLong.CURLOPT_IPRESOLVE, CurlConstant.CURL_IPRESOLVE_V4);
    return this;
  }

  public CurlHttp setIpResolveV6() {
    curl.curlEasySetopt(OptLong.CURLOPT_IPRESOLVE, CurlConstant.CURL_IPRESOLVE_V6);
    return this;
  }

  public CurlHttp setIpResolveWhatever() {
    curl.curlEasySetopt(OptLong.CURLOPT_IPRESOLVE, CurlConstant.CURL_IPRESOLVE_WHATEVER);
    return this;
  }

  public CurlHttp closeSslVerify() {
    curl.curlEasySetopt(OptLong.CURLOPT_SSL_VERIFYHOST, 0);
    curl.curlEasySetopt(OptLong.CURLOPT_SSL_VERIFYPEER, 0);
    return this;
  }

  /**
   * @param proxy [scheme]://
   * @return
   * @see <a href="http://curl.haxx.se/libcurl/c/CURLOPT_PROXY.html">http://curl.haxx.se/libcurl/c/CURLOPT_PROXY.html</a>
   */
  public CurlHttp setProxy(String proxy) {
    curl.curlEasySetopt(OptObjectPoint.CURLOPT_PROXY, proxy);
    closeSslVerify();
    return this;
  }

  /**
   * Auto redirect 301/302 request
   *
   * @param follow default true
   * @return
   */
  public CurlHttp setFollowLocation(boolean follow) {
    followLocation = follow;
    return this;
  }

  public CurlHttp setCookieJar(String cookieJarPath) {
    curl.curlEasySetopt(OptObjectPoint.CURLOPT_COOKIEFILE, cookieJarPath);
    curl.curlEasySetopt(OptObjectPoint.CURLOPT_COOKIEJAR, cookieJarPath);
    return this;
  }

  /**
   * @param max Setting the limit to 0 will make libcurl refuse any redirect.
   *            Set it to -1 for an infinite number of redirects.
   *            Default 3
   * @return
   */
  public CurlHttp setMaxRedirects(int max) {
    maxRedirects = max;
    return this;
  }

  /**
   * set http proxy
   *
   * @param host
   * @param port
   * @return
   */
  public CurlHttp setHttpProxy(String host, int port) {
    this.proxyHost = host;
    this.proxyPort = port;
    closeSslVerify();
    return this;
  }

  /**
   * Using system proxy
   *
   * @param yes default yes
   * @return
   */
  public CurlHttp useSystemProxy(boolean yes) {
    this.useSystemProxy = yes;
    return this;
  }

  /**
   * Post via multipart/form-data<br/>
   * <p>
   * default: false <br/>
   * if {@link #addMultiPartPostParam(String, String, String, byte[])} called, always post as multipart)
   *
   * @param yes
   * @return
   */
  public CurlHttp postAsMultipart(boolean yes) {
    this.asMultipart = yes;
    return this;
  }

  public CurlHttp getUrl(String url) {
    if (checkCurrentRequestMethod()) {
      throw new IllegalArgumentException("A " + requestMethod + " url already set!");
    }
    requestMethod = CurlRequestMethod.GET;
    this.url = url;

    return this;
  }


  public CurlHttp postUrl(String url) {
    if (checkCurrentRequestMethod()) {
      throw new IllegalArgumentException("A " + requestMethod + " url already set!");
    }
    requestMethod = CurlRequestMethod.POST;
    this.url = url;

    return this;
  }

  public CurlHttp url(String url) {
    this.url = url;
    return this;
  }

  public CurlHttp method(String method) {
    if (!CurlRequestMethod.METHOD_SET.contains(method)) {
      throw new IllegalArgumentException("unknown request method : " + method);
    }
    if (checkCurrentRequestMethod()) {
      throw new IllegalArgumentException("A " + requestMethod + " url already set!");
    }
    this.requestMethod = method;
    return this;
  }

  public CurlHttp addParam(String name, String value) {
    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException("name is required");
    }

    if (simplePairList == null) {
      simplePairList = new ArrayList<NameValuePair>();
    }
    simplePairList.add(new NameValuePair(name, value));
    return this;
  }

  /**
   * @param name   will send as key[]
   * @param values
   * @return
   */
  public CurlHttp addParam(String name, List<String> values) {
    if (values != null && values.size() > 0) {
      for (String value : values) {
        addParam(name, value);
      }
    }
    return this;
  }

  /**
   * add multipart form field(post only)
   *
   * @param name        required
   * @param filename    if null, "file.dat" will be used
   * @param contentType if null, curl will detect from filename
   * @param content     required
   * @return
   */
  public CurlHttp addMultiPartPostParam(String name, String filename, String contentType, byte[] content) {
    if (StringUtils.isBlank(name)) {
      throw new IllegalArgumentException("name is required");
    }
    if (content == null || content.length == 0) {
      throw new IllegalArgumentException("content is required");
    }
    if (multiPartList == null) {
      multiPartList = new ArrayList<MultiPart>();
    }
    multiPartList.add(new MultiPart(name, filename, contentType, content));
    return this;
  }

  /**
   * set raw body to post(override {@link #addParam(String, List)} {@link #addParam(String, String)} and {@link #addMultiPartPostParam(String, String, String, byte[])})
   *
   * @param mimeType
   * @param data
   * @return
   */
  public CurlHttp setBody(String mimeType, byte[] data) {
    addHeader("Content-Type", mimeType);
    this.body = data;
    return this;
  }

  private final Pattern STATUS_PATTERN = Pattern.compile("HTTP/\\d+\\.\\d+\\s+(\\d+)\\s+");

  private void setHeaderCallback(final Map<String, String> resultMap, final AtomicInteger status, final StringBuffer statusLine) {
    curl.curlEasySetopt(OptFunctionPoint.CURLOPT_HEADERFUNCTION, new Curl.WriteCallback() {

      @Override
      public int readData(byte[] data) {
        if (data == null) {
          return 0;
        }
        String header = new String(data);
        if (!StringUtils.isBlank(header)) {
          String[] nameAndValue = StringUtils.split(header, ":", 2);
          if (nameAndValue.length == 2) {
            resultMap.put(nameAndValue[0].trim(), nameAndValue[1].trim());
          } else if (nameAndValue.length == 1) {
            Log.i(TAG, "header: " + nameAndValue[0]);
            Matcher m = STATUS_PATTERN.matcher(nameAndValue[0]);
            if (m.find()) {
              int code = Integer.valueOf(m.group(1));
              if (code != 100) {
                // HTTP/1.1 100 Continue
                status.set(code);
                statusLine.append(nameAndValue[0]);
              }
            }
          }
        }
        return data.length;
      }
    });
  }

  private void setBodyCallback(final OutputStream os) {
    curl.curlEasySetopt(OptFunctionPoint.CURLOPT_WRITEFUNCTION, new Curl.WriteCallback() {

      @Override
      public int readData(byte[] data) {
        if (data != null && data.length == 0) {
          return 0;
        }
        try {
          os.write(data);
        } catch (IOException e) {
          Log.w(TAG, "write fail", e);
          return 0;
        }
        return data.length;
      }
    });
  }

  public CurlResponse perform() throws CurlException {
    if (url == null) {
      throw new IllegalStateException("url getUrl/postUrl/url not set");
    }

    // - populate headers
    setRequestHeaders();

    // - populate params
    // - set post data (if needed)
    @SuppressWarnings("unchecked")
    Map<String, String> resultHeaderMap = new CaseInsensitiveMap<String, String>();
    ByteArrayOutputStream bodyOs = new ByteArrayOutputStream();

    AtomicInteger status = new AtomicInteger();
    StringBuffer statusLine = new StringBuffer();
    setHeaderCallback(resultHeaderMap, status, statusLine);
    setBodyCallback(bodyOs);

    if (!CurlRequestMethod.GET.equals(requestMethod)) {
      // body populate from params
      setPostParams();
    } else {
      String params = getEncodedBodyParams();
      if (!StringUtils.isBlank(params)) {
        if (url.contains("?")) {
          if (url.endsWith("&")) {
            url += params;
          } else {
            url += "&" + params;
          }
        } else {
          url += "?" + params;
        }

//        logger.v("contact params to url: %s", url);
      }
    }

    switch (requestMethod) {
      case CurlRequestMethod.GET:
        curl.curlEasySetopt(OptLong.CURLOPT_HTTPGET, 1);
        break;
      case CurlRequestMethod.POST:
        curl.curlEasySetopt(OptLong.CURLOPT_POST, 1);
        break;
      default:
        curl.curlEasySetopt(OptObjectPoint.CURLOPT_CUSTOMREQUEST, requestMethod);
    }

    curl.curlEasySetopt(OptObjectPoint.CURLOPT_URL, url);

    // follow
    curl.curlEasySetopt(OptLong.CURLOPT_FOLLOWLOCATION, followLocation ? 1 : 0);
    if (followLocation) {
//      Log.d(TAG, "set FOLLOWLOCATION: " + maxRedirects);
      curl.curlEasySetopt(OptLong.CURLOPT_MAXREDIRS, maxRedirects);
    }

    // proxy
    setProxy();

    // - do request
    try {
      CurlCode code = curl.curlEasyPerform();
      if (code != CurlCode.CURLE_OK) {
        throw new CurlException(code);
      }

//      for (Map.Entry<String, String> entry : resultHeaderMap.entrySet()) {
//        Log.d(TAG, "Header: " + entry.getKey() + ": " + entry.getValue());
//      }

      // - read response

      // parse result code from headers
      return new CurlResponse(status.get(), statusLine.toString(), resultHeaderMap, bodyOs.toByteArray());
    } finally {
      curl.curlEasyCleanup();
    }
  }

  private void setRequestHeaders() {
    List<String> headers = new ArrayList<String>(headerMap.size());
    for (Map.Entry<String, String> entry : headerMap.entrySet()) {
      String value = entry.getValue();
      if (value == null) {
        value = "";
      }
//      Log.d(TAG, "header: " + entry.getKey() + " => " + value);
      headers.add(entry.getKey() + ": " + value);
    }
//    Log.d(TAG, "add hreader: " + headers.size());
    curl.curlEasySetopt(OptObjectPoint.CURLOPT_HTTPHEADER, headers.toArray(new String[headerMap.size()]));
  }

  private boolean isMultipart() {
    return asMultipart || (multiPartList != null && multiPartList.size() > 0);
  }

  private void setPostParams() {
//    Log.d(TAG, "set post params");
    if (!isMultipart()) {
      // simple form
      // user provided body
      byte[] postBody = body;
      if (body == null) {
        String bodyString = getEncodedBodyParams();
        if (bodyString != null) {
          postBody = bodyString.getBytes();
        }
      }

      if (postBody != null) {
        curl.curlEasySetopt(OptLong.CURLOPT_POSTFIELDSIZE, postBody.length);
        curl.curlEasySetopt(OptObjectPoint.CURLOPT_POSTFIELDS, postBody);
      } else {
        // no data
        curl.curlEasySetopt(OptLong.CURLOPT_POSTFIELDSIZE, 0);
      }
    } else {
      // multipart
      List<MultiPart> finalList = new ArrayList<MultiPart>();
      if (multiPartList != null && multiPartList.size() > 0) {
        for (MultiPart part : multiPartList) {
          finalList.add(part);
        }
      }

      if (simplePairList != null && simplePairList.size() > 0) {
        for (NameValuePair pair : simplePairList) {
          finalList.add(new MultiPart(pair.getName(), null, null, pair.getValue().getBytes()));
        }
      }

//      Log.d(TAG, "Set MultiPart data: " + finalList.size());
      CurlFormCode result = curl.setFormdata(finalList);
      if (result != CurlFormCode.CURL_FORMADD_OK) {
        throw new RuntimeException("set formdata fail: " + result);
      }
    }
  }

  private String getEncodedBodyParams() {
    if (simplePairList != null && simplePairList.size() > 0) {
      StringBuilder body = new StringBuilder();
      boolean first = true;
      for (NameValuePair pair : simplePairList) {
        // name value field
        if (!first) {
          body.append("&");
        }
        first = false;

        try {
          String name = URLEncoder.encode(pair.getName(), "UTF-8");
          String value = URLEncoder.encode(pair.getValue(), "UTF-8");
          body.append(name);
          body.append("=");
          body.append(value);
//          logger.v("Append field: %s=%s", name, value);
        } catch (UnsupportedEncodingException e) {
          Log.w(TAG, "encode faile: name=" + pair.getName() + ", value=" + pair.getValue(), e);
        }
      }
      return body.toString();
    }
    return null;
  }

  private void setProxy() {
    if (useSystemProxy && proxyHost == null) {
      proxyHost = System.getProperty("http.proxyHost");
      String proxyPortStr = System.getProperty("http.proxyPort");
      if (proxyPortStr != null) {
        proxyPort = Integer.valueOf(proxyPortStr);
      }
    }
    if (proxyHost != null) {
//      Log.d(TAG, "Set http proxy: " + proxyHost + ":" + proxyPort);
      curl.curlEasySetopt(OptObjectPoint.CURLOPT_PROXY, proxyHost);
      curl.curlEasySetopt(OptLong.CURLOPT_PROXYPORT, proxyPort);
    }
  }

  private boolean checkCurrentRequestMethod() {
    return requestMethod != null && !"".equals(requestMethod);
  }

  public static class CurlRequestMethod {
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String PATCH = "PATCH";

    public static Set<String> METHOD_SET = new HashSet<>();

    static {
      METHOD_SET.add(GET);
      METHOD_SET.add(POST);
      METHOD_SET.add(PUT);
      METHOD_SET.add(DELETE);
      METHOD_SET.add(PATCH);
    }
  }
}

