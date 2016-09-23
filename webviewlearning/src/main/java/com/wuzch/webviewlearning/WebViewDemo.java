package com.wuzch.webviewlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewDemo extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        webView= (WebView) findViewById(R.id.webview);
        webView.loadUrl("http://www.baidu.com");    //加载一个网页,但是需要在Mainfest设置权限
    }
}
