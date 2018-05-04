package com.bbbond.mxcurllib;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class CurlResponse {

  private static final String TAG = CurlResponse.class.getSimpleName();
  private final int status;
  private final String statusLine;
  private final Map<String, List<String>> headers;
  private final byte[] body;
  private transient String bodyString;
  private transient byte[] decodedBody;

  public CurlResponse(int status, String statusLine, Map<String, List<String>> headers, byte[] body) {
    super();
    this.status = status;
    this.statusLine = statusLine;
    this.headers = headers;
    this.body = body;
  }

  public int getStatus() {
    return status;
  }

  /**
   * @return may contains \n at end
   */
  public String getStatusLine() {
    return statusLine;
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public List<String> getHeader(String header) {
    List<String> headers = this.headers.get(header);
    if (headers != null && headers.size() > 0) {
      return headers;
    }
    return new ArrayList<>();
  }

  /**
   * @return original body
   */
  public byte[] getBody() {
    return body;
  }

  /**
   * @return decoded if body gzipped
   */
  public byte[] getDecodedBody() throws IOException {
    if (getHeader("Content-Encoding").size() <= 0 || !"gzip".equalsIgnoreCase(getHeader("Content-Encoding").get(0))) {
      return body;
    }
    if (decodedBody == null) {
      Log.d(TAG, "uncompress gzipped content");
      GZIPInputStream gzis = new GZIPInputStream(new ByteArrayInputStream(body));
      ByteArrayOutputStream byos = new ByteArrayOutputStream(body.length * 3);
      byte[] buf = new byte[4096];
      int len;
      while ((len = gzis.read(buf, 0, buf.length)) != -1) {
        byos.write(buf, 0, len);
      }
      decodedBody = byos.toByteArray();
      gzis.close();
      byos.close();
    }

    return decodedBody;
  }

  /**
   * @return
   * @throws IOException
   */
  public String getBodyAsString() throws IOException {
    if (bodyString == null) {
      bodyString = new String(getDecodedBody());
    }
    return bodyString;
  }

  /**
   *
   * @param charset
   * @return
   * @throws IOException
   */
  public String getBodyAsString(String charset) throws IOException {
    if (bodyString == null) {
      bodyString = new String(getDecodedBody(), charset);
    }
    return bodyString;
  }
}
