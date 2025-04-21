package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity {

    private Button btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.quiz_info_activity);

        btn_play = findViewById(R.id.btn_play);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView tvWelcome = findViewById(R.id.Welcome);
        TextView score_result = findViewById(R.id.Score_result);
        TextView question_result = findViewById(R.id.Question_result);

        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            tvWelcome.setText("Welcome " + username);
        }
        btn_play.setOnClickListener(v -> {
            Intent intent = new Intent(QuizActivity.this, PlayActivity.class);
            startActivity(intent);
        });
        if (getIntent().hasExtra("correctAnswers")) {
            int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
            score_result.setText(String.valueOf(correctAnswers));
            question_result.setText(String.format("%d/5", correctAnswers));
        }
    }
}
