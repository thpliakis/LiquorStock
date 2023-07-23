package com.adital.liquorstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView liquorsGV;
    ArrayList<Liquor> liquorArrayList = new ArrayList<Liquor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liquorsGV = findViewById(R.id.idliquorsGV);

        liquorArrayList.add(new Liquor("Beer", R.drawable.ic_beer));
        liquorArrayList.add(new Liquor("Gin", R.drawable.ic_gin));
        liquorArrayList.add(new Liquor("Champagne", R.drawable.ic_champagne));
        liquorArrayList.add(new Liquor("Rum", R.drawable.ic_rum));
        liquorArrayList.add(new Liquor("Vermouth", R.drawable.ic_vermouth));
        liquorArrayList.add(new Liquor("Tequila", R.drawable.ic_tequila));
        liquorArrayList.add(new Liquor("Wine", R.drawable.ic_wine));
        liquorArrayList.add(new Liquor("Whiskey", R.drawable.ic_whiskey));
        liquorArrayList.add(new Liquor("Vodka", R.drawable.ic_vodka));


        LiquorAdapter adapter = new LiquorAdapter(this, liquorArrayList);
        liquorsGV.setAdapter(adapter);

        liquorsGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /* Todo navigate user to liquor activity */
                //liquorsGV.get
                Toast.makeText(MainActivity.this ,"Hello world " + adapter.getItem(i).getLiquor_name(),Toast.LENGTH_LONG).show();
            }
        });


    }
}