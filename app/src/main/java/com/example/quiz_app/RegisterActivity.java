package com.example.quiz_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword, etConfirm;
    private Button btnRegister, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        etUsername    = findViewById(R.id.etNewUsername);
        etPassword    = findViewById(R.id.etNewPassword);
        etConfirm= findViewById(R.id.etConfirmPassword);
        btnRegister      = findViewById(R.id.btnRegister);
        btnBackToLogin   = findViewById(R.id.btnBackToLogin);


        DatabaseHelper dbHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {
            String u = etUsername.getText().toString().trim();
            String p = etPassword.getText().toString().trim();
            String c = etConfirm.getText().toString().trim();
            if (u.isEmpty() || p.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!p.equals(c)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }
            if (dbHelper.register(u, p)) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
