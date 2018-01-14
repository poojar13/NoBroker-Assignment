package com.example.pooja.nobrokersampleapp.presenter;

import android.app.Activity;
import android.content.Intent;

import com.example.pooja.nobrokersampleapp.View.Activities.FilterActivity;
import com.example.pooja.nobrokersampleapp.View.Activities.MainActivity;

/**
 * Created by pooja on 14/1/18.
 */

public class FilterActivityPresenter {

    public void initiateMainActivity(Activity activity){
        Intent i = new Intent(activity,MainActivity.class);
        activity.startActivity(i);
        activity.finish();
    }
}
