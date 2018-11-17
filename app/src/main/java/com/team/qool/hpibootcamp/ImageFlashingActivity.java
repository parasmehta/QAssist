package com.team.qool.hpibootcamp;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ImageFlashingActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_flashing);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        image = findViewById(R.id.image);
        createTutorial();
        image.setImageResource(android.R.color.white);
    }


    private void createTutorial(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("How many blue squares can you spot?")
            .setTitle("Watch carefully!")
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                image.setImageResource(R.drawable.red_and_blue_2);
                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                image.setImageResource(android.R.color.white);
                                createFeedbackTextField();
                            }
                        });
                    }
                }, 500);

            }
        });
        builder.create().show();
    }

    private void createFeedbackTextField() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(ImageFlashingActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setMessage("How many blue squares did you see?")
                .setTitle("Uuh..That was quick!")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        int number = Integer.valueOf(input.getText().toString());
                        if (number == 1){
                            Toast.makeText(ImageFlashingActivity.this,"That was correct! You just earned 5 credits for this assessment.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(ImageFlashingActivity.this,"The right answer would have been 1. Anyway, thanks for doing this assessment, you just earned 5 credits for it.", Toast.LENGTH_LONG).show();
                        }
                        finish();
                    }
                });

        builder.create().show();
    }
}
