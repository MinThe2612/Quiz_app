package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;

    private Button btnLogin, btnGoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoRegister = findViewById(R.id.btnGoRegister);


            DatabaseHelper dbHelper = new DatabaseHelper(this);

            btnLogin.setOnClickListener(v -> {
                String u = etUsername.getText().toString().trim();
                String p = etPassword.getText().toString().trim();
                if (u.isEmpty() || p.isEmpty()) {
                    Toast.makeText(this, "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (dbHelper.login(u, p)) {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    String username_wl = etUsername.getText().toString().trim();
                    intent.putExtra("username", username_wl);
                    startActivity(intent);
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            });

            btnGoRegister.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
    }
}