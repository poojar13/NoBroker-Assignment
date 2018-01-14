package com.example.pooja.nobrokersampleapp.View.Interface;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by pooja on 10/1/18.
 */

public interface RetrofitInterface {
    @GET("ChIJLfyY2E4UrjsRVq4AjI7zgRY")
    Call<JsonElement> getProperties(@Query("lat_lng") String latlong,
                                    @Query("rent") String rent,
                                    @Query("travelTime") int travelTime,
                                    @Query("pageNo") int pageNumber,
                                    @Query("type") String bhkType,
                                    @Query("buildingType") String buildingType,
                                    @Query("furnishing") String furnishingType);
}
