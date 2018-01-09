package com.example.ngockhanh.mvpexample.Presenter.PresenterLogin;

import android.util.Log;

import com.example.ngockhanh.mvpexample.Model.Login.ModelLogin;
import com.example.ngockhanh.mvpexample.Model.Login.ModelResponeToPresenter;

/**
 * Created by Ngoc Khanh on 1/2/2018.
 */

public class PresenterLogin implements ModelResponeToPresenter{
    ModelLogin modelLogin;
    ViewLoginListener callback;
    public PresenterLogin(ViewLoginListener callback){
        this.callback=callback;

    }

    public void receivedHandleLogin(String email, String password){
        modelLogin=new ModelLogin(this);
        modelLogin.handleLogin(email,password);


    }

    @Override
    public void onLoginSuccess() {
        Log.d("Presenter Login", "Presenter: Success");
        callback.onLoginSuccess();

    }

    @Override
    public void onLoginFailed() {
        Log.d("Presenter Login", "Presenter: Failed");
        callback.onLoginFailed();
    }
}
