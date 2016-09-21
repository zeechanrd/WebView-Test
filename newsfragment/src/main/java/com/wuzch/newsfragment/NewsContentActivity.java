package com.wuzch.newsfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/8/29.
 */
public class NewsContentActivity extends AppCompatActivity {
    //让别人读懂是启动NewsContentActivity的方法
    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        /**
         * 获得传入的新闻标题和内容
         */
        String newsTitle=getIntent().getStringExtra("news_title");
        String newsContent=getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment= (NewsContentFragment) getSupportFragmentManager().
                findFragmentById(R.id.news_content_fragment);
        //刷新NewsContentFragment界面
        newsContentFragment.reFresh(newsTitle,newsContent);
    }
}
