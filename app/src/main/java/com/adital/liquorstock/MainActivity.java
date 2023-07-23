package com.adital.liquorstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Mainactivity for the app
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */
public class MainActivity extends AppCompatActivity {

    private GridView liquorsGV;
    ArrayList<Liquor> liquorArrayList = new ArrayList<Liquor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liquorsGV = findViewById(R.id.idliquorsGV);

        liquorArrayList.add(new Liquor("Beer", R.drawable.ic_beer,1));
        liquorArrayList.add(new Liquor("Gin", R.drawable.ic_gin,2));
        liquorArrayList.add(new Liquor("Champagne", R.drawable.ic_champagne,3));
        liquorArrayList.add(new Liquor("Rum", R.drawable.ic_rum,4));
        liquorArrayList.add(new Liquor("Vermouth", R.drawable.ic_vermouth,5));
        liquorArrayList.add(new Liquor("Tequila", R.drawable.ic_tequila,6));
        liquorArrayList.add(new Liquor("Wine", R.drawable.ic_wine,7));
        liquorArrayList.add(new Liquor("Whiskey", R.drawable.ic_whiskey,8));
        liquorArrayList.add(new Liquor("Vodka", R.drawable.ic_vodka,9));


        LiquorAdapter adapter = new LiquorAdapter(this, liquorArrayList);
        liquorsGV.setAdapter(adapter);

        liquorsGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /* Todo navigate user to liquor activity */
                //liquorsGV.get
                //Toast.makeText(MainActivity.this ,"Hello world " + adapter.getItem(i).getLiquor_name(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, LiquorActivity.class);
                intent.putExtra("liquorType", adapter.getItem(i).getId());
                startActivity(intent);
            }
        });


    }
}