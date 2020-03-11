package com.project.QuicKorier.view.activity;

import android.os.Bundle;
import android.text.TextUtils;

import com.project.QuicKorier.R;
import com.project.QuicKorier.databinding.ActivityMainBinding;
import com.project.QuicKorier.model.EditUserDetails;
import com.project.QuicKorier.viewmodel.EditUserViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private EditUserViewModel editUserViewModel;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUserViewModel = ViewModelProviders.of(this).get(EditUserViewModel.class);
        mainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        mainBinding.setLifecycleOwner(this);
        //mainBinding.setLoginViewModel(editUserViewModel);

        editUserViewModel.getUser().observe(this, new Observer<EditUserDetails>() {
            @Override
            public void onChanged(EditUserDetails editUserDetails) {

                try {
                    if (TextUtils.isEmpty(editUserDetails.getUsername())) {
                        mainBinding.editProfileUsernameEditText.setError("Enter an E-Mail Address");
                        mainBinding.editProfileUsernameEditText.requestFocus();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
