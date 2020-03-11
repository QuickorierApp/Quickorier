package com.project.QuicKorier.viewmodel;

import android.util.Log;
import android.view.View;

import com.project.QuicKorier.model.EditUserDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EditUserViewModel extends ViewModel {

    public MutableLiveData<String> userName = new MutableLiveData<>();
    public MutableLiveData<String> designation = new MutableLiveData<>();
    public MutableLiveData<String> dateOfBirth = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();

    private MutableLiveData<EditUserDetails> editUserMutableLiveData;

    public MutableLiveData<EditUserDetails> getUser() {

        if (editUserMutableLiveData == null) {
            editUserMutableLiveData = new MutableLiveData<>();
        }
        return editUserMutableLiveData;

    }

    public void onClick(View view) {

        EditUserDetails loginUser = new EditUserDetails();
        //userName.getValue(), designation.getValue()
        Log.v("EditTxt",""+userName.getValue());
        editUserMutableLiveData.setValue(loginUser);

    }


}
