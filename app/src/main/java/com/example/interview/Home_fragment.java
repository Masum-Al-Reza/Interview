package com.example.interview;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.interview.Adapter.Recyclerviewadapter;
import com.example.interview.Viewmodel.Album_viewmodel;
import com.example.interview.Viewmodel.Loginviemodel;
import com.example.interview.pojos.Photos;

import java.util.List;


public class Home_fragment extends Fragment {
    private RecyclerView recyclerView;
    private Album_viewmodel album_viewmodel;
    private Loginviemodel loginviemodel;
    public Home_fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.album_menu,menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logoutalbm:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure you want to Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        loginviemodel.logout();
                        Navigation.findNavController(getView()).navigate(R.id.login_fragment);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert3 = builder.create();
        alert3.show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        album_viewmodel= ViewModelProviders.of(this).get(Album_viewmodel.class);
        loginviemodel= ViewModelProviders.of(this).get(Loginviemodel.class);
        return inflater.inflate(R.layout.fragment_home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerview);

        album_viewmodel.getAllCountyWise("photos").observe(getActivity(), new Observer<List<Photos>>() {
            @Override
            public void onChanged(List<Photos> photos) {
                Recyclerviewadapter allCountryWiseAdpater = new Recyclerviewadapter(getActivity(),photos);
                LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(allCountryWiseAdpater);
            }

        });


    }
}