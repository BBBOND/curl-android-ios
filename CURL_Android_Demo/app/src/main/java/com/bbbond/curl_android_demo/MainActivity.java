package com.bbbond.curl_android_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bbbond.curl_android_demo.mxcurl.Header;
import com.bbbond.curl_android_demo.mxcurl.Response;
import com.bbbond.curl_android_demo.mxcurl.internal.CurlUtils;

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
          String url = "http://192.168.1.12:3000";
          Header header = new Header();
          header.add("Content-Type", "application/json; charset=utf-8");
//          Response response = CurlUtils.get("http://blog.bbbond.cn/api/posts.json", header.toHeaderString());
          Response response = CurlUtils.get(url, header.toHeaderString());
          Log.d(TAG, "run response code: " + response.getCode());
          Log.d(TAG, "run response header: " + response.getHeader().toString());
          Log.d(TAG, "run response body: " + response.getBody());

          Response response1 = CurlUtils.post(url, "{\"a\": 1, \"b\": \"233\"}", header.toHeaderString());
          Log.d(TAG, "run response1 code: " + response1.getCode());
          Log.d(TAG, "run response1 header: " + response1.getHeader().toString());
          Log.d(TAG, "run response1 body: " + response1.getBody());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}
