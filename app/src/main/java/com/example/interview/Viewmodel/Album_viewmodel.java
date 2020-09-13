package com.example.interview.Viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.interview.Repos.Albumrepos;
import com.example.interview.pojos.Photos;

import java.util.List;

public class Album_viewmodel extends ViewModel {
    Albumrepos albumrepos;
    public Album_viewmodel(){
        albumrepos=new Albumrepos();
    }

    public MutableLiveData<List<Photos>> getAllCountyWise(String endUrl)
    {
        return albumrepos.allphotos(endUrl);
    }

}
