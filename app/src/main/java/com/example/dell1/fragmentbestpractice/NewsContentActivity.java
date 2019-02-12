package com.example.dell1.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {
    public static void actionStart(Context context,String newsTitle,int newsContent){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("news_title");
        //如果"news_content"没有值的话就取1的值赋给变量
        int newsContent=getIntent().getIntExtra("news_content",1);
        NewsContentFragment newsContentFragment=(NewsContentFragment)
                getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);
    }
}
