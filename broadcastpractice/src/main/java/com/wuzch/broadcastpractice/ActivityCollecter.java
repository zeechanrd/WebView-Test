package com.wuzch.broadcastpractice;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class ActivityCollecter {
    //创建活动的集合
    public static List<AppCompatActivity> activities=new ArrayList<AppCompatActivity>();
    public static void  addActivity(AppCompatActivity activity){
        activities.add(activity);
    }
    public static void removeActivity(AppCompatActivity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        //增强for循环语句，对集合或者数组进行遍历,*for(Type name:Array/Set)*
        for (AppCompatActivity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
