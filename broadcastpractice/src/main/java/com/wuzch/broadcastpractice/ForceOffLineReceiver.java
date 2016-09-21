package com.wuzch.broadcastpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/20.
 */
public class ForceOffLineReceiver extends BroadcastReceiver {
    public static String Action="com.wuzch.broadcastpractice.intent.action.FORCE_OFFLINE";
    @Override
    public void onReceive(final Context context, final Intent intent) {
        /**
         * 构建对话框
         */
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
        dialogBuilder.setTitle("警告 Warning");
        dialogBuilder.setMessage("你被强制下线，请重新登录。" +
                "You are forced to be offline.Please try to login again.");
        //将对话框设置为不可取消
        dialogBuilder.setCancelable(false);
        //设置有效按钮
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                      ActivityCollecter.finishAll();//销毁所有活动
        Intent intent1=new Intent(context,LoginActivity.class);
        /**
         *  设置此状态，记住以下原则，首先会查找是否存在和被启动的Activity具有相同的亲和性的任务栈
         *  （即taskAffinity，注意同一个应用程序中的activity的亲和性一样，所以下面的a情况会在同
         *  一个栈中），如果有，刚直接把这个栈整体移动到前台，并保持
         *  栈中的状态不变，即栈中的activity顺序不变，如果没有，则新建一个栈来存放被启动的activity
         */
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);//重新启动LoginActivity
       }
    });
        AlertDialog alertDialog=dialogBuilder.create();
        //需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}
