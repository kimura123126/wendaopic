package com.example.dell1.fragmentbestpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by DELL1 on 2018/12/10.
 */

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        RecyclerView newsTitleRecyclerView=(RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter=new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }
    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();

        News news1= new News();
        news1.setTitle("wendao1");
        news1.setContent(R.drawable.wendao1);
        newsList.add(news1);

        News news2= new News();
        news2.setTitle("wendao2");
        news2.setContent(R.drawable.wendao2);
        newsList.add(news2);

        News news3= new News();
        news3.setTitle("wendao3");
        news3.setContent(R.drawable.wendao3);
        newsList.add(news3);

        News news4= new News();
        news4.setTitle("wendao4");
        news4.setContent(R.drawable.wendao4);
        newsList.add(news4);

        News news5= new News();
        news5.setTitle("wendao5");
        news5.setContent(R.drawable.wendao5);
        newsList.add(news5);

        News news6= new News();
        news6.setTitle("wendao6");
        news6.setContent(R.drawable.wendao6);
        newsList.add(news6);

        News news7= new News();
        news7.setTitle("wendao7");
        news7.setContent(R.drawable.wendao7);
        newsList.add(news7);

        News news8= new News();
        news8.setTitle("wendao8");
        news8.setContent(R.drawable.wendao8);
        newsList.add(news8);

        News news9= new News();
        news9.setTitle("wendao9");
        news9.setContent(R.drawable.wendao9);
        newsList.add(news9);

        News news10= new News();
        news10.setTitle("wendao10");
        news10.setContent(R.drawable.wendao10);
        newsList.add(news10);

        News news11= new News();
        news11.setTitle("wendao11");
        news11.setContent(R.drawable.wendao11);
        newsList.add(news11);

        News news12= new News();
        news12.setTitle("wendao12");
        news12.setContent(R.drawable.wendao12);
        newsList.add(news12);

        News news13= new News();
        news13.setTitle("wendao13");
        news13.setContent(R.drawable.wendao13);
        newsList.add(news13);

        News news14= new News();
        news14.setTitle("wendao14");
        news14.setContent(R.drawable.wendao14);
        newsList.add(news14);

        News news15= new News();
        news15.setTitle("wendao15");
        news15.setContent(R.drawable.wendao15);
        newsList.add(news15);

        News news16= new News();
        news16.setTitle("wendao16");
        news16.setContent(R.drawable.wendao16);
        newsList.add(news16);

        News news17= new News();
        news17.setTitle("wendao17");
        news17.setContent(R.drawable.wendao17);
        newsList.add(news17);




     /*   for (int i=1;i<=50;i++){
            News news= new News();
            news.setTitle("This is news title"+i);
            news.setContent(getRandomLengthContent("This is news content"+i+"."));
            newsList.add(news);
        }*/
        return newsList;
    }

  /*  private String getRandomLengthContent(String content){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(content);
        }
        return builder.toString();
    }*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;
        }else{
            isTwoPane=false;
        }
    }
    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> mNewsList;
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;
            public ViewHolder(View view){
                super(view);
                newsTitleText=(TextView)view.findViewById(R.id.news_title);
            }
        }
        public NewsAdapter(List<News> newsList){
            mNewsList=newsList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final ViewHolder holder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    News news=mNewsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        NewsContentFragment newsContentFragment=(NewsContentFragment)
                                getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else {
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;

        }
        @Override
        public void onBindViewHolder(ViewHolder holder,int position){
            News news=mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }
        @Override
        public int getItemCount(){
            return mNewsList.size();
        }

    }
}
