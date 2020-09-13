package com.example.interview.Repos;

import androidx.lifecycle.MutableLiveData;

import com.example.interview.Helper.Retrofitclient;
import com.example.interview.ServiceApi.Data_service;
import com.example.interview.pojos.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Albumrepos {
    MutableLiveData<List<Photos>> allphotosld = new MutableLiveData<>();

    public MutableLiveData<List<Photos>> allphotos(String endurl){
        Data_service albumInfoServiceApi = Retrofitclient.getretrofitclient().create(Data_service.class);

        albumInfoServiceApi.getphotos(endurl).enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                allphotosld.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {

            }
        });
        return allphotosld;

    }

}
