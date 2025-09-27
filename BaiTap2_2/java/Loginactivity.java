package com.example.hunghaha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Loginactivity extends AppCompatActivity {
//khai báo
    TextView note;
    EditText lloginName,lpassWord;
    Button llbt1,lbt2;
    String regUsername = "";
    String regPassword = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //ánh xạ
        llbt1 = findViewById(R.id.llbt1);
        lbt2 = findViewById(R.id.lbt2);
        lloginName = findViewById(R.id.lloginName);
        lpassWord = findViewById(R.id.lpassWord);
        note = findViewById(R.id.note);
        // Nhận dữ liệu từ Registeractivity
        Intent intent = getIntent();
        if (intent != null) {
            regUsername = intent.getStringExtra("username");
            regPassword = intent.getStringExtra("password");
        }
        // chuyển màn hình
        lbt2.setOnClickListener(v->
            startActivity(new Intent(Loginactivity.this, Registeractivity.class))
        );
        llbt1.setOnClickListener(v -> {
            String username = lloginName.getText().toString().trim();
            String password = lpassWord.getText().toString().trim();

            // Kiểm tra có để trống không
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Loginactivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                return;
            }
            //so thông tin
            if (username.equals(regUsername) && password.equals(regPassword)) {
                startActivity(new Intent(Loginactivity.this, menuactivity.class));
            } else {
                Toast.makeText(Loginactivity.this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

