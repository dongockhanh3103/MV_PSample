package com.example.ngockhanh.mvpexample.Model.Login;

import android.util.Log;

/**
 * Created by Ngoc Khanh on 1/2/2018.
 */

public class ModelLogin {
    private ModelResponeToPresenter callback;
    public ModelLogin(ModelResponeToPresenter callback){
        this.callback=callback;
    }
    public  void handleLogin(String email, String pass){
        Log.d("user info", "Info: "+ email+" |"+ pass);
        if("khanh".equals(email) && "khanh".equals(pass)){
            Log.d("Model Login", "handleLogin: Successs");
            callback.onLoginSuccess();
        }
        else {
            Log.d("Model Login", "handleLogin: Failed");
            callback.onLoginFailed();
        }

    }
}
