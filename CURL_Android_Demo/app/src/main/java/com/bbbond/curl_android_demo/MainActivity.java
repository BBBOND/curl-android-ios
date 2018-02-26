package com.bbbond.curl_android_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bbbond.curl_android_demo.utils.CurlUtils;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    new Thread(new Runnable() {
      @Override
      public void run() {
        Log.d(TAG, "onCreate: " + new String(CurlUtils.get("http://blog.bbbond.cn/api/posts.json")));
      }
    }).start();
  }
}
