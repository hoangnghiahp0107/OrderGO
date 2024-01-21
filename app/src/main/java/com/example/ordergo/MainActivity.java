package com.example.ordergo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText textUser, textPassword;
    Button btnLogin;
    private static final int min_username = 8;
    private static final int min_password = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textUser.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                if (isValidInput(username, password)) {
                    Intent intent = new Intent(MainActivity.this, TableActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void addControl(){
        textUser = findViewById(R.id.textUser);
        textPassword = findViewById(R.id.textPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }
    private boolean isValidInput(String username, String password) {
        if (username.length() < min_username) {
            textUser.setError("Tên người dùng không hợp lệ");
            return false;
        }
        if (password.length() < min_password) {
            textPassword.setError("Mật khẩu không hợp lệ");
            return false;
        }
        return true;
    }
}