package com.earthquake.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<Items>> {

    private String mUrl;

    public NewsLoader( Context context,String url) {
        super(context);
        mUrl = url;

    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Items> loadInBackground() {
        if(mUrl==null){
        return null;}
        List<Items> news = QyeryUtils.fetchNewsData(mUrl);
        return (ArrayList<Items>) news;
    }
}
