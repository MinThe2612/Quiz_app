package com.example.quiz_app;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {
    private Button btn_a, btn_b, btn_c, btn_d, btn_next, btn_prev;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.quiz_play_activity);
        btn_a = findViewById(R.id.btn_a);
        btn_b = findViewById(R.id.btn_b);
        btn_c = findViewById(R.id.btn_c);
        btn_d = findViewById(R.id.btn_d);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);
        question = findViewById(R.id.question);
        
        btn_a.setOnClickListener(v -> {
            checkAnswer(btn_a.getText().toString());
        });

        }

    private void checkAnswer(String string) {
    }
}

}
