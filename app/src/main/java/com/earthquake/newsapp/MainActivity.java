package com.earthquake.newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Loader;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Items>>{
    private NewsAdapter newsAdapter;
    private static final String news_Link = "https://newsapi.org/v2/top-headlines?country=eg&apiKey=1aa6f4adf28244688ed21b3cca5250f7";
    private ListView listView;
    private TextView mtextView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtextView = (TextView)findViewById(R.id.txt_check_item);
        progressBar = (ProgressBar)findViewById(R.id.prograss_bar);
        listView= findViewById(R.id.list_view);
        newsAdapter = new NewsAdapter(this,new ArrayList<Items>());
        listView.setAdapter(newsAdapter);

        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(0, null, this);
        }else {
            progressBar.setVisibility(View.GONE);
            mtextView.setText("No internet Connection ... ");
        }


        listView.setEmptyView(mtextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items news = newsAdapter.getItem(position);
                //Uri newsURI = Uri.parse(news.getUrl());
                //Intent web = new Intent(Intent.ACTION_VIEW,newsURI);
                //startActivity(web);
                Intent send = new Intent(MainActivity.this,thisWebView.class);
                send.putExtra("url",news.getUrl());
                send.putExtra("label",news.getTitle());
                startActivity(send);

            }
        });
    }

    @Override
    public Loader<List<Items>> onCreateLoader(int id, Bundle args) {

        return new NewsLoader(this,news_Link);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Items>> loader, List<Items> data) {
        newsAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            newsAdapter.addAll(data);
        }
        mtextView.setText("No News at this time");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<Items>> loader) {
        newsAdapter.clear();
    }
}
