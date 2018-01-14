package com.example.pooja.nobrokersampleapp.View.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pooja.nobrokersampleapp.R;
import com.example.pooja.nobrokersampleapp.presenter.FilterActivityPresenter;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {

    int bhk1selected=1,bhk2selected=1,
        bhk3selected=1,appartmentselected=1,
        independentfloorselected=1,independenthousecheck=1,
        semifurnishedcheck=1,fullyfurnishedcheck=1;
    String bhktype1,bhktype2,bhktype3;
    String builderType1,builderType2,builderType3;
    String furnishingType1,furnishingType2;
    TextView clear;
    Context context;
    FilterActivityPresenter filterActivityPresenter = new FilterActivityPresenter();

    Button bhk1,bhk2,bhk3,appartment,independentHouse,independentFloor,semiFurnished,fullyFurnished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        initView();
        checkSharedPreferance();

    }

    public void initView(){
        context = this;
        ((Button) findViewById(R.id.saveFilterButton)).setOnClickListener(this);
        bhk1 = ((Button) findViewById(R.id.bhk1Button));
        bhk1.setOnClickListener(this);
        bhk2 = ((Button) findViewById(R.id.bhk2Button));
        bhk2.setOnClickListener(this);
        bhk3 = ((Button) findViewById(R.id.bhk3Button));
        bhk3.setOnClickListener(this);
        appartment = ((Button) findViewById(R.id.appartmentButton));
        appartment.setOnClickListener(this);
        independentFloor = ((Button) findViewById(R.id.independentFloorButton));
        independentFloor.setOnClickListener(this);
        independentHouse = ((Button) findViewById(R.id.independentHouseButton));
        independentHouse.setOnClickListener(this);
        semiFurnished = ((Button) findViewById(R.id.semiFurnishedButton));
        semiFurnished.setOnClickListener(this);
        fullyFurnished= ((Button) findViewById(R.id.fullyFurnishedButton));
        fullyFurnished.setOnClickListener(this);
        clear=(TextView)findViewById(R.id.clear);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bhk1Button:
                if(bhk1selected==1){
                    bhk1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    bhk1.setTextColor(getResources().getColor(android.R.color.white));
                    bhk1selected=0;
                }
                else {
                    bhk1.setBackgroundColor(getResources().getColor(android.R.color.white));
                    bhk1.setTextColor(getResources().getColor(android.R.color.black));
                    bhk1selected=1;
                }
                break;
            case R.id.bhk2Button:
                if(bhk2selected==1){
                    bhk2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    bhk2.setTextColor(getResources().getColor(android.R.color.white));
                    bhk2selected=0;
                }
                else  {
                    bhk2.setBackgroundColor(getResources().getColor(android.R.color.white));
                    bhk2.setTextColor(getResources().getColor(android.R.color.black));
                    bhk2selected=1;
                }
                break;
            case R.id.bhk3Button:
                if(bhk3selected==1){
                    bhk3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    bhk3.setTextColor(getResources().getColor(android.R.color.white));
                    bhk3selected=0;
                }
                else {
                    bhk3.setBackgroundColor(getResources().getColor(android.R.color.white));
                    bhk3.setTextColor(getResources().getColor(android.R.color.black));
                    bhk3selected=1;
                }
                break;
            case R.id.appartmentButton:
                if(appartmentselected==1){
                    appartment.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    appartment.setTextColor(getResources().getColor(android.R.color.white));
                    appartmentselected=0;
                }
                else {
                    appartment.setBackgroundColor(getResources().getColor(android.R.color.white));
                    appartment.setTextColor(getResources().getColor(android.R.color.black));
                    appartmentselected=1;
                }
                break;
            case R.id.independentHouseButton:
                if(independenthousecheck==1){
                    independentHouse.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    independentHouse.setTextColor(getResources().getColor(android.R.color.white));
                    independenthousecheck=0;
                }
                else {
                    independentHouse.setBackgroundColor(getResources().getColor(android.R.color.white));
                    independentHouse.setTextColor(getResources().getColor(android.R.color.black));
                    independenthousecheck=1;
                }
                break;
            case R.id.independentFloorButton:
                if(independentfloorselected==1){
                    independentFloor.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    independentFloor.setTextColor(getResources().getColor(android.R.color.white));
                    independentfloorselected=0;
                }
                else {
                    independentFloor.setBackgroundColor(getResources().getColor(android.R.color.white));
                    independentFloor.setTextColor(getResources().getColor(android.R.color.black));
                    independentfloorselected=1;
                }
                break;
            case R.id.fullyFurnishedButton:
                if(fullyfurnishedcheck==1){
                    fullyFurnished.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    fullyFurnished.setTextColor(getResources().getColor(android.R.color.white));
                    fullyfurnishedcheck=0;
                }
                else {
                    fullyFurnished.setBackgroundColor(getResources().getColor(android.R.color.white));
                    fullyFurnished.setTextColor(getResources().getColor(android.R.color.black));
                    fullyfurnishedcheck=1;
                }
                break;
            case R.id.semiFurnishedButton:
                if(semifurnishedcheck==1){
                    semiFurnished.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    semiFurnished.setTextColor(getResources().getColor(android.R.color.white));
                    semifurnishedcheck=0;
                }
                else {
                    semifurnishedcheck=1;
                    semiFurnished.setBackgroundColor(getResources().getColor(android.R.color.white));
                    semiFurnished.setTextColor(getResources().getColor(android.R.color.black));
                }
                break;
            case R.id.saveFilterButton:

                setSharedPreferance();
                filterActivityPresenter.initiateMainActivity(FilterActivity.this);
                break;
            case R.id.clear:

                clearFilter();
                break;

        }

    }

    public void setSharedPreferance(){
        if(bhk1selected==0){
            bhktype1="BHK1";
        }else {
            bhktype1=null;
        }
        if(bhk2selected==0){
            bhktype2="BHK2";
        }else {
            bhktype2=null;
        }
        if(bhk3selected==0){
            bhktype3="BHK3";
        }else {
            bhktype3=null;
        }
        if(appartmentselected==0){
            builderType1="AP";
        }else {
            builderType1=null;
        }
        if(independentfloorselected==0){
            builderType3="IF";
        }else {
            builderType3=null;
        }
        if(independenthousecheck==0){
            builderType2="IH";
        }else {
            builderType2=null;
        }
        if(fullyfurnishedcheck==0){
            furnishingType2="FULLY_FURNISHED";
        }else {
            furnishingType2=null;
        }
        if(semifurnishedcheck==0){
            furnishingType1="SEMI_FURNISHED";
        }else {
            furnishingType1=null;
        }
        SharedPreferences.Editor editor = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE).edit();
        editor.putString("bhkType1",bhktype1 );
        editor.putString("bhkType2",bhktype2 );
        editor.putString("bhkType3",bhktype3 );
        editor.putString("builderType1",builderType1 );
        editor.putString("builderType2",builderType2 );
        editor.putString("builderType3",builderType3 );
        editor.putString("furnishingType1",furnishingType1 );
        editor.putString("furnishingType2",furnishingType2 );
        editor.apply();
        editor.commit();
    }

    private void getSharerdPreferance() {

        SharedPreferences prefs = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
        bhktype1 = prefs.getString("bhkType1", null);
        bhktype2 = prefs.getString("bhkType2", null);
        bhktype3 = prefs.getString("bhkType3", null);
        builderType1 = prefs.getString("builderType1", null);
        builderType2 = prefs.getString("builderType2", null);
        builderType3 = prefs.getString("builderType3", null);
        furnishingType1 = prefs.getString("furnishingType1", null);
        furnishingType2 = prefs.getString("furnishingType2", null);
    }

    public void checkSharedPreferance(){
        getSharerdPreferance();
        if(bhktype1!=null){
            bhk1selected=0;
            bhk1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bhk1.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            bhk1selected=1;
            bhk1.setBackgroundColor(getResources().getColor(android.R.color.white));
            bhk1.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(bhktype2!=null){
            bhk2selected=0;
            bhk2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bhk2.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            bhk2selected=1;
            bhk2.setBackgroundColor(getResources().getColor(android.R.color.white));
            bhk2.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(bhktype3!=null){
            bhk3selected=0;
            bhk3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            bhk3.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            bhk3selected=1;
            bhk3.setBackgroundColor(getResources().getColor(android.R.color.white));
            bhk3.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(builderType1!=null){
            appartmentselected=0;
            appartment.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            appartment.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            appartmentselected=1;
            appartment.setBackgroundColor(getResources().getColor(android.R.color.white));
            appartment.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(builderType2!=null){
            independenthousecheck=0;
            independentHouse.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            independentHouse.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            independenthousecheck=1;
            independentHouse.setBackgroundColor(getResources().getColor(android.R.color.white));
            independentHouse.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(builderType3!=null){
            independentfloorselected=0;
            independentFloor.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            independentFloor.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            independentfloorselected=1;
            independentFloor.setBackgroundColor(getResources().getColor(android.R.color.white));
            independentFloor.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(furnishingType1!=null){
            semifurnishedcheck=0;
            semiFurnished.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            semiFurnished.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            semifurnishedcheck=1;
            semiFurnished.setBackgroundColor(getResources().getColor(android.R.color.white));
            semiFurnished.setTextColor(getResources().getColor(android.R.color.black));
        }
        if(furnishingType2!=null){
            fullyfurnishedcheck=0;
            fullyFurnished.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            fullyFurnished.setTextColor(getResources().getColor(android.R.color.white));
        }else {
            fullyfurnishedcheck=1;
            fullyFurnished.setBackgroundColor(getResources().getColor(android.R.color.white));
            fullyFurnished.setTextColor(getResources().getColor(android.R.color.black));
        }
    }

    public void clearFilter(){
        SharedPreferences preferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        checkSharedPreferance();
    }


}
