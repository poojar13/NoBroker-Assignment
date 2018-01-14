package com.example.pooja.nobrokersampleapp.View.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.pooja.nobrokersampleapp.Model.Adapters.RecyclerViewAdapter;
import com.example.pooja.nobrokersampleapp.R;
import com.example.pooja.nobrokersampleapp.View.Interface.OnBottomReachedListener;
import com.example.pooja.nobrokersampleapp.View.Interface.ResponseInterface;
import com.example.pooja.nobrokersampleapp.presenter.MainActivityPresenter;


import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ResponseInterface {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    int page = 1;
    double latitude, longitude;
    String bhkType, buildingType, furnishingType;
    String bhkType1, bhkType2, bhkType3;
    String builderType1, builderType2, builderType3;
    String furnishingType1, furnishingType2;
    MainActivityPresenter mainActivityPresenter = new MainActivityPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getProperties();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filterImage:
                mainActivityPresenter.initiateFilterActivity(MainActivity.this);
                break;
        }
    }

    @Override
    public void onSuccess(JSONObject jsonObject) {
        recyclerViewAdapter.setData(mainActivityPresenter.parseJsonDataToPropertyList(jsonObject));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onFailure(String message) {
        mainActivityPresenter.showToast(MainActivity.this, message);
    }

    public void initView() {
        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ((ImageView) findViewById(R.id.filterImage)).setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerViewAdapter.setOnBottomReachedListener(new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {
                page = page + 1;
                getProperties();
            }
        });
    }

    private void getProperties() {
        getSharerdPreferance();
        latitude = 12.9279232;
        longitude = 77.6271078;
        mainActivityPresenter.getProperties(String.valueOf(latitude) + "," + String.valueOf(longitude), "0.500000", 30, page, bhkType, builderType1, furnishingType, MainActivity.this);
    }

    private void getSharerdPreferance() {
        SharedPreferences prefs = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
        bhkType1 = prefs.getString("bhkType1", null);
        bhkType2 = prefs.getString("bhkType2", null);
        bhkType3 = prefs.getString("bhkType3", null);
        builderType1 = prefs.getString("builderType1", null);
        builderType2 = prefs.getString("builderType2", null);
        builderType3 = prefs.getString("builderType3", null);
        furnishingType1 = prefs.getString("furnishingType1", null);
        furnishingType2 = prefs.getString("furnishingType2", null);
        bhkType = bhkType1 + "," + bhkType2 + "," + bhkType3;
        buildingType = builderType1 + "," + builderType2 + "," + builderType3;
        furnishingType = furnishingType1 + "," + furnishingType2;

        if (bhkType != null) {
            Log.d("bhkType", bhkType);
            Log.d("buildingType", buildingType);
            Log.d("furnishingType", furnishingType);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        initView();
        getProperties();

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();
        this.finish();
    }

}
