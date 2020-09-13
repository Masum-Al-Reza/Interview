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
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.interview.Viewmodel.Loginviemodel;

public class Login_fragment extends Fragment {
private EditText EmaillogET,passwordlogET;
private Loginviemodel loginviemodel;

private ImageButton regBtn1;
private Button logBTN;


    public Login_fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        (getActivity()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        loginviemodel= ViewModelProviders.of(this).get(Loginviemodel.class);

        return inflater.inflate(R.layout.fragment_login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EmaillogET=view.findViewById(R.id.userlogemailinput);
        passwordlogET=view.findViewById(R.id.passwrodloginput);
        regBtn1=view.findViewById(R.id.registerbutton);
        logBTN=view.findViewById(R.id.loginbtn);

        logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=EmaillogET.getText().toString();
                String password=passwordlogET.getText().toString();
                if (email.isEmpty() ){
                    Toast.makeText(getContext(), "provide info", Toast.LENGTH_SHORT).show();
                    EmaillogET.setError("provide email");
                }else if (password.isEmpty()){
                    passwordlogET.setError("provide password");


                }else {
                    loginviemodel.login(email,password);
                }

            }
        });
        loginviemodel.statelivedata.observe(getActivity(), new Observer<Loginviemodel.Authenticationstate>() {
            @Override
            public void onChanged(Loginviemodel.Authenticationstate authenticationstate) {
                switch (authenticationstate){
                    case AUTHENTICATIONSTATED:
                        Navigation.findNavController(view).navigate(R.id.home_fragment);
                        break;
                    case UNAUTHENTICATIONSTATED:
                        Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        regBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.registration);

            }
        });

    }

}