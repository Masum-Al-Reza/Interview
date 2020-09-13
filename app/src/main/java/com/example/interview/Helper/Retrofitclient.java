package com.example.interview.Helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    public static final   String  Baseurl="https://jsonplaceholder.typicode.com/";
    public  static Retrofit getretrofitclient(){
        return new Retrofit.Builder().baseUrl(Baseurl).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
