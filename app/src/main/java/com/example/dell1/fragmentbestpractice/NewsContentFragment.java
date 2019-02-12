package com.example.dell1.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL1 on 2018/12/10.
 */

public class NewsContentFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,int newsContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText=(TextView) view.findViewById(R.id.news_title);
        ImageView newsContentImage =(ImageView) view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentImage.setImageResource(newsContent);
    }
}
