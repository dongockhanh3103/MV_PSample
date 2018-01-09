package com.example.ngockhanh.mvpexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ngockhanh.mvpexample.Presenter.PresenterLogin.PresenterLogin;
import com.example.ngockhanh.mvpexample.Presenter.PresenterLogin.ViewLoginListener;
import com.example.ngockhanh.mvpexample.R;

public class MainActivity extends AppCompatActivity implements ViewLoginListener {
    EditText edtUsername,edtPassword;
    Button btnLogin;
    PresenterLogin presenterLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComp();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();
                presenterLogin.receivedHandleLogin(email,pass);

            }
        });
    }

    void initComp(){
        edtUsername= (EditText)findViewById(R.id.txtMail);
        edtPassword= (EditText) findViewById(R.id.txtPass);
        btnLogin   = (Button) findViewById(R.id.btnLogin);
        presenterLogin=new PresenterLogin(this);
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
    }
}
