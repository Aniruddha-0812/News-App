package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NewsItemClicked {

    private ShimmerFrameLayout mShimmerViewContainer;

    NewsListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
        adapter = new NewsListAdapter(this);
        recyclerView.setAdapter(adapter);
    }


    private void fetchData(){
        Intent i = getIntent();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,i.getStringExtra("URL_TAG"), null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<Data> newsArray = new ArrayList<Data>();
                        try {
                            JSONArray array = response.getJSONArray("articles");

                            for(int i = 0 ; i < array.length() ; i++) {
                                JSONObject object = array.getJSONObject(i);

                                String title = object.getString("title");
                                String Description = object.getString("description");
                                String urlimage = object.getString("urlToImage");
                                String Url = object.getString("url");

                                Data News = new Data(title , Description , urlimage ,Url);

                                newsArray.add(News);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mShimmerViewContainer.stopShimmerAnimation();
                        mShimmerViewContainer.setVisibility(View.GONE);
                        adapter.updateNews(newsArray);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }


    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    @Override
    public void onItemClicked(Data item) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.getmUrl()));
    }

}
