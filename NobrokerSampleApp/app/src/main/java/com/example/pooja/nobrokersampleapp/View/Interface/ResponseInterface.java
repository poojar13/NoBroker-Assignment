package com.example.pooja.nobrokersampleapp.View.Interface;

import org.json.JSONObject;

/**
 * Created by pooja on 14/1/18.
 */

public interface ResponseInterface {
    void onSuccess(JSONObject jsonObject);
    void onFailure(String message);
}
