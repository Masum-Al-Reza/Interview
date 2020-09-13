package com.example.interview.ServiceApi;

import com.example.interview.pojos.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Data_service {
    @GET
    Call<List<Photos>> getphotos(@Url String endUrl);

}
