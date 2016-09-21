package com.wuzch.broadcastpractice;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private Button btnForceOffLine;
    private ForceOffLineReceiver forceOffLineReceiver;
    private IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnForceOffLine = (Button) findViewById(R.id.btnForceOffLine);
        /**
         * 注册广播接收器
         */
        forceOffLineReceiver=new ForceOffLineReceiver();
        intentFilter=new IntentFilter();
        intentFilter.addAction(forceOffLineReceiver.Action);
        registerReceiver(forceOffLineReceiver,intentFilter);
        btnForceOffLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ForceOffLineReceiver.Action);
                sendBroadcast(i);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(forceOffLineReceiver);
    }
}
