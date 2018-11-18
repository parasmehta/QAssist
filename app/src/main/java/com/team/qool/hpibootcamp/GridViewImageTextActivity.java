package com.team.qool.hpibootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewImageTextActivity extends AppCompatActivity {

    GridView androidGridView;
    ImageView imgView;
    TextView score;
    final int REQ_CODE_MINI_GAME = 100;

    String[] gridViewString = {
            "Hearing", "Vision", "Attention", "Memory", "Movement" , "Checkup"
    } ;

    int[] gridViewImageId = {
            R.drawable.ic_hearing_black_48dp, R.drawable.ic_remove_red_eye_black_48dp,
            R.drawable.ic_center_focus_weak_black_48dp, R.drawable.ic_settings_system_daydream_black_48dp,
            R.drawable.ic_directions_walk_black_48dp, R.drawable.stethoscope
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);

        score = findViewById(R.id.score);
//        imgView = (ImageView) findViewById(R.id.imageFavourites);
//        imgView.setImageResource(R.drawable.ic_launcher_background);
        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(GridViewImageTextActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(GridViewImageTextActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
                if(gridViewString[i].equals("Attention")){
                    Intent myIntent = new Intent(GridViewImageTextActivity.this, FullscreenActivity.class);
                    GridViewImageTextActivity.this.startActivity(myIntent);
                } else if(gridViewString[i].equals("Checkup")) {
                    Intent myIntent = new Intent(GridViewImageTextActivity.this, CheckupActivity.class);
                    startActivityForResult(myIntent, REQ_CODE_MINI_GAME);
                } else {
                    startActivityForResult(new Intent(GridViewImageTextActivity.this, ImageFlashingActivity.class), REQ_CODE_MINI_GAME);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==REQ_CODE_MINI_GAME){
            int prevScore = Integer.valueOf(score.getText().toString().split(" ")[1]);
            prevScore+=5;
            score.setText("Score: " + prevScore);
        }
    }
}