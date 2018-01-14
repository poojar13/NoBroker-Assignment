package com.example.pooja.nobrokersampleapp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.pooja.nobrokersampleapp.Model.NetworkHelpers.RetrofitInstance;
import com.example.pooja.nobrokersampleapp.Model.Pojo.PropertyData;
import com.example.pooja.nobrokersampleapp.View.Activities.FilterActivity;
import com.example.pooja.nobrokersampleapp.View.Interface.ResponseInterface;
import com.example.pooja.nobrokersampleapp.View.Interface.RetrofitInterface;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pooja.nobrokersampleapp.Utils.AppConstant.BASE_URL;
import static com.example.pooja.nobrokersampleapp.Utils.AppConstant.IMAGE_URL;

/**
 * Created by pooja on 14/1/18.
 */

public class MainActivityPresenter {

    public void initiateFilterActivity(Activity activity){
        Intent i = new Intent(activity,FilterActivity.class);
        activity.startActivity(i);
    }

    public void getProperties(String latlng, String rentQuery, int travelTime, int pageNo,String bhkType, String buildingType,String furnishingType,final ResponseInterface responseInterface){
        final RetrofitInterface apiService = RetrofitInstance.getClient(BASE_URL).create(RetrofitInterface.class);
        Call<JsonElement> call = apiService.getProperties(latlng,rentQuery,travelTime, pageNo,bhkType,buildingType,furnishingType);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if(response.isSuccessful()){
                    Log.d("response",response.body().toString());
                    try {
                        responseInterface.onSuccess(new JSONObject(response.body().toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                responseInterface.onFailure("Something went wrong!");
            }
        });
    }

    public ArrayList<PropertyData> parseJsonDataToPropertyList(JSONObject jsonObject){
        ArrayList<PropertyData> propertyList = new ArrayList<>();
        try {
            JSONArray dataArray = jsonObject.getJSONArray("data");
            for(int i = 0; i< dataArray.length();i++) {
                if (JSONObject.NULL != dataArray.get(i)) {
                    JSONObject data = dataArray.getJSONObject(i);
                    if (data != null) {
                        PropertyData propertyData = new PropertyData();
                        propertyData.setTitle(data.getString("propertyTitle"));
                        propertyData.setSecondaryTitle(data.getString("nbLocality"));
                        propertyData.setType(data.getString("typeDesc"));
                        propertyData.setBathroom(data.getString("bathroom"));
                        propertyData.setFurnishingState(data.getString("furnishing"));
                        propertyData.setDeposit(data.getString("deposit"));
                        propertyData.setPropertyArea(data.getLong("propertySize"));
                        JSONArray photosArray = data.getJSONArray("photos");
                        for (int j = 0; j < photosArray.length(); j++) {
                            if (JSONObject.NULL != photosArray.get(j)) {
                                JSONObject photosObject = photosArray.getJSONObject(j);
                                if (photosObject != null) {
                                    JSONObject imagesMap = photosObject.getJSONObject("imagesMap");
                                    String imageName = imagesMap.getString("original");
                                    if(imageName!=null){
                                        int index=imageName.indexOf("_");
                                        String imageSubstring = imageName.substring(0,index);
                                        String url = IMAGE_URL+imageSubstring+"/"+imageName;
                                        propertyData.setPhotos(url);
                                    }

                                }
                            }
                        }
                        propertyList.add(propertyData);
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return propertyList;
    }

    public void showToast(Activity activity, String message){
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
