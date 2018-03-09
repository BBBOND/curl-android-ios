package com.bbbond.curl_android_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bbbond.mxcurllib.CurlHttp;
import com.bbbond.mxcurllib.CurlResponse;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          CurlResponse curlResponse = CurlHttp
              .newInstance()
              .getUrl("https://www.baidu.com/")
//              .setHttpProxy("192.168.0.133", 8888)
              .closeSslVerify()
              .perform();

          Log.d(TAG, "run: curlResponse" + curlResponse.getBodyAsString());

//          String url = "http://192.168.0.133:3000";
//          Header header = new Header();
//          header.add("Content-Type", "application/json; charset=utf-8");
////          Response response = CurlUtils.get("http://blog.bbbond.cn/api/posts.json", header.toHeaderString());
//
//          Log.e(TAG, "run request get url: " + url);
//          Response response = CurlUtils.get(MainActivity.this, "https://www.baidu.com/", Header.getEmptyHeaderString());
//          Log.e(TAG, "run response code: " + response.getCode());
//          Log.e(TAG, "run response header: " + response.getHeader().toString());
//          Log.e(TAG, "run response body: " + response.getBody());
//
//          Log.e(TAG, "run request1 header: " + header.toString());
//          Log.e(TAG, "run request1 post url: " + url);
//          Log.e(TAG, "run request1 post params: " + "{\"a\": 1, \"b\": \"233\"}");
//          Response response1 = CurlUtils.post(MainActivity.this, url, "{\"a\": 1, \"b\": \"233\"}", header.toHeaderString());
//          Log.e(TAG, "run response1 code: " + response1.getCode());
//          Log.e(TAG, "run response1 header: " + response1.getHeader().toString());
//          Log.e(TAG, "run response1 body: " + response1.getBody());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}
