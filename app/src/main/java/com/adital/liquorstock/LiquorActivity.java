package com.adital.liquorstock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Liquor activity.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */
public class LiquorActivity extends AppCompatActivity {

    private ListView liquorslistLW;
    private ImageButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);

        liquorslistLW = findViewById(R.id.liquorsList);
        addBtn = findViewById(R.id.addbtn);



    }
}