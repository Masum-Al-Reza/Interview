package com.example.interview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.interview.Viewmodel.Loginviemodel;
import com.example.interview.pojos.UserInformationPojo;


public class Registration_fragment extends Fragment {
private Loginviemodel loginviemodel;
private EditText FirstnameET,LastnameET,EmailET,NumberET,PasswortET,ConfirmPasswordET;
private Button RegBTN;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        (getActivity()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginviemodel= ViewModelProviders.of(this).get(Loginviemodel.class);

        return inflater.inflate(R.layout.fragment_registration, container, false);

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {

        FirstnameET=view.findViewById(R.id.firstNameET);
        LastnameET=view.findViewById(R.id.lastNameET);
        EmailET=view.findViewById(R.id.userEmailEt);
        NumberET=view.findViewById(R.id.phoneNumET);
        PasswortET=view.findViewById(R.id.userPasswordET);
        ConfirmPasswordET=view.findViewById(R.id.userRetypePassword);
        RegBTN=view.findViewById(R.id.registerbutton2);

        RegBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name=FirstnameET.getText().toString();
                String last_name=LastnameET.getText().toString();
                String email=EmailET.getText().toString();
                String number=NumberET.getText().toString();
                String password=PasswortET.getText().toString();
                String conirmpass=ConfirmPasswordET.getText().toString();
              if (first_name.isEmpty()){
                  FirstnameET.setError("provide name");
              }else if(last_name.isEmpty()){
                  LastnameET.setError("provide last name");
              }else if(last_name.isEmpty()){
                  LastnameET.setError("provide last name");
              }else if(email.isEmpty()){
                  EmailET.setError("provide last name");
              }else if(number.isEmpty()){
                  NumberET.setError("provide last name");
              }
                else {
                    if (password.equals(conirmpass)) {
                        UserInformationPojo userInformationPojo = new UserInformationPojo(null, first_name, last_name, email,number,password);
                       loginviemodel.register(userInformationPojo);
                        Navigation.findNavController(view).navigate(R.id.login_fragment);

                    }else {
                        Toast.makeText(getActivity(), "not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });



    }



}