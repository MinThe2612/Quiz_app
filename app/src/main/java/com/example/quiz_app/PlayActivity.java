package com.example.quiz_app;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {
    private Button btn_a, btn_b, btn_c, btn_d, btn_next, btn_prev;
    private TextView question;

    int currentIndex = 0;

    String[] result = new String[]{"A", "B", "C", "D", "A"};
    String[] answers = new String[result.length];

    List<String> questionList = new ArrayList<>();


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

        View.OnClickListener answerClickListener = v -> {
            Button selected = (Button) v;
            String selectedAnswer = selected.getText().toString().substring(0, 1);
            answers[currentIndex] = selectedAnswer;
            changeButtonColor(selected, ContextCompat.getColor(PlayActivity.this, R.color.green));
        };

        loadQuestions();
        updateQuestion(currentIndex);

        btn_a.setOnClickListener(answerClickListener);
        btn_b.setOnClickListener(answerClickListener);
        btn_c.setOnClickListener(answerClickListener);
        btn_d.setOnClickListener(answerClickListener);

        btn_next.setOnClickListener(v -> {
            currentIndex++;
            if (currentIndex < result.length) {
                updateQuestion(currentIndex);
            } else {
                checkAnswers();
            }
        });
        btn_prev.setOnClickListener(v -> {
                currentIndex--;
                if (currentIndex >= 0) {
                    updateQuestion(currentIndex);
                }
                else {
                    currentIndex = 0;
                }
        });
    }

    private void loadQuestions() {
        questionList.add(0, "1+1 = ? \n A.1 \n B.2 \n C.3 \n D.4");
        questionList.add(1, "2+2 = ? \n A.1 \n B.2 \n C.3 \n D.4");
        questionList.add(2, "3+3 = ? \n A.1 \n B.2 \n C.3 \n D.4");
        questionList.add(3, "4+4 = ? \n A.1 \n B.2 \n C.3 \n D.4");
        questionList.add(4, "5+5 = ? \n A.1 \n B.2 \n C.3 \n D.4");
    }

    private void updateQuestion(int index) {
        question.setText("Câu hỏi " + (index + 1) + ": " + questionList.get(index));
        changeButtonColor(btn_a, ContextCompat.getColor(this, R.color.Red_rose));
    }

    private void changeButtonColor(Button button, int color) {
        btn_a.setBackgroundColor(ContextCompat.getColor(this, R.color.Red_rose));
        btn_b.setBackgroundColor(ContextCompat.getColor(this, R.color.Red_rose));
        btn_c.setBackgroundColor(ContextCompat.getColor(this, R.color.Red_rose));
        btn_d.setBackgroundColor(ContextCompat.getColor(this, R.color.Red_rose));
        button.setBackgroundColor(color);

    }

    private void checkAnswers() {
        int correctAnswers = 0;
        for (int i = 0; i < result.length; i++) {
            if (answers[i].equals(result[i])) {
                correctAnswers++;
            }
        }
        Toast.makeText(this, "Số câu đúng: " + correctAnswers, Toast.LENGTH_SHORT).show();
    }
}

