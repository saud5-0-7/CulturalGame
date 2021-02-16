package com.barmej.culturalwordsgamebysaud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton;

    private ImageView imageView;

    private final int[] culturalImages = {
            R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8,
            R.drawable.icon_9,
            R.drawable.icon_10,
            R.drawable.icon_11,
            R.drawable.icon_12,
            R.drawable.icon_13,
    };

    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view_question);
        currentIndex = 0;
        imageView.setImageResource(culturalImages[currentIndex]);
        



        imageButton = (ImageButton) findViewById(R.id.button_open_answer);
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAnswer();
            }
        });

    }
    public void openAnswer(){
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra("index", currentIndex);
        startActivity(intent);
    }

    public void changePhoto(View view) {
        currentIndex++;
        if(currentIndex >= culturalImages.length) {
            currentIndex = 0;
        }
        imageView.setImageResource(culturalImages[currentIndex]);

    }
    public void onShareQuestionClicked(View view){
        Intent intent = new Intent(MainActivity.this,ShareActivity.class);
        intent.putExtra("Image Id", culturalImages[currentIndex]) ;
        startActivity(intent);
    }

    }



