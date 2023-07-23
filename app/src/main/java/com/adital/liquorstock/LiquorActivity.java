package com.adital.liquorstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Liquor activity.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */

public class LiquorActivity extends AppCompatActivity {

    RelativeLayout lAct_parent;
    private ListView liquorslistLW;
    private ImageButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);

        lAct_parent = findViewById(R.id.lAct_parent);
        liquorslistLW = findViewById(R.id.liquorsList);
        addBtn = findViewById(R.id.addbtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("liquorType");
        }

        DataBaseHelper dataBaseHelper = new DataBaseHelper(LiquorActivity.this);
        // TODO fetch data from database foe liquorType

        // TODO addbtn onclicklistener to add liqueurs on database
        // TODO create adapter for liquor item list view 1:15 in video

        liquorslistLW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
        View view = View.inflate(this, R.layout.liquor_popup,null);
        //
        Button done = view.findViewById(R.id.btnDone);
        // TODO all view for liquorpopup layout abd their funcctionalities

        //
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(view ,width, height, false);
        //

        popupWindow.showAtLocation(lAct_parent, Gravity.CENTER,0,0);

        // TODO functionalities of textView and editView

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }
}