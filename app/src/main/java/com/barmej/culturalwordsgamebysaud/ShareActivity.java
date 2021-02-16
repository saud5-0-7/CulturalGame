package com.barmej.culturalwordsgamebysaud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ShareActivity extends AppCompatActivity {

    private EditText shareText;
    private ImageView imageView;
    private int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        shareText = findViewById(R.id.edit_text_share_title);
        imageView = findViewById(R.id.image_view_question);
        imageId = getIntent().getIntExtra("Image Id", 0);
        imageView.setImageResource(imageId);
    }


    public void onShareQuestionClicked(View view){
            Uri imageUri = Uri.parse("android.resource://" + getPackageName()
                + "/drawable/" + imageId);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText.getText().toString());
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "send"));

    }

}