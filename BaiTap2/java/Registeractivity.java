package com.example.hunghaha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registeractivity extends AppCompatActivity {
     EditText rloginname, rphone, rdate, rpassword ;
     Button rbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registeractivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rloginname = findViewById(R.id.rloginname);
        rbt = findViewById(R.id.rbt);
        rphone = findViewById(R.id.rphone);
        rdate = findViewById(R.id.rdate);
        rpassword = findViewById(R.id.rpassword);
        rbt.setOnClickListener(v -> {
            String name = rloginname.getText().toString().trim();
            String phone = rphone.getText().toString().trim();
            String date = rdate.getText().toString().trim();
            String password = rpassword.getText().toString().trim();

            // Kiểm tra không để trống
            if (name.isEmpty() || phone.isEmpty() || date.isEmpty() || password.isEmpty()) {
                Toast.makeText(Registeractivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return; // dừng luôn, không chạy tiếp
            }

            // Kiểm tra số điện thoại
            if (phone.length() != 10 || !phone.matches("\\d{10}")) {
                Toast.makeText(Registeractivity.this, "Số điện thoại phải gồm đúng 10 chữ số!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(Registeractivity.this, Loginactivity.class);
            intent.putExtra("username", name);
            intent.putExtra("password", password);
            Toast.makeText(Registeractivity.this, "Account Created!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();

        });
    }
}