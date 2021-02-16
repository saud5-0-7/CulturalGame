package com.barmej.culturalwordsgamebysaud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        TextView answerTextView = findViewById(R.id.text_view_answer);

        int currentIndex = getIntent().getIntExtra("index", 0);

        String name = getResources().getStringArray(R.array.cultural_names)[currentIndex];
        String desc = getResources().getStringArray(R.array.cultural_desc)[currentIndex];

        answerTextView.setText(name + " : " + desc);

    }

    public void onReturnClicked(View view){
        finish();
    }

}