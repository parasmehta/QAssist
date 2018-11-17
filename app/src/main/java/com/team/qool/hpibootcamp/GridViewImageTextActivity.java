package com.team.qool.hpibootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewImageTextActivity extends AppCompatActivity {

    GridView androidGridView;

    String[] gridViewString = {
            "Vision", "Hearing", "Memory", "Movement", "Attention", "Checkup"
    } ;

    int[] gridViewImageId = {
            R.drawable.red_and_blue_1, R.drawable.red_and_blue_1,
            R.drawable.red_and_blue_1, R.drawable.red_and_blue_1,
            R.drawable.red_and_blue_1, R.drawable.red_and_blue_1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(GridViewImageTextActivity.this, gridViewString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(GridViewImageTextActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
                startActivity(new Intent(GridViewImageTextActivity.this, ImageFlashingActivity.class));
            }
        });

    }
}