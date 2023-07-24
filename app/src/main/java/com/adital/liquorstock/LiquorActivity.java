package com.adital.liquorstock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

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
    private  String liquorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);

        lAct_parent = findViewById(R.id.lAct_parent);
        liquorslistLW = findViewById(R.id.liquorsList);
        addBtn = findViewById(R.id.addbtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            liquorType = extras.getString("liquorType");
        }

        // Fetch the list of liqueurs
        DataBaseHelper dataBaseHelper = new DataBaseHelper(LiquorActivity.this);
        ArrayList<LiquorModel> liquorList = dataBaseHelper.getLiquorList(liquorType);

        // Adapter for listView
        LiquorListAdapter adapter = new LiquorListAdapter(this, liquorList);
        liquorslistLW.setAdapter(adapter);

        // Clicking on a item in the list.
        liquorslistLW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showPopupWindowListItem();
            }
        });

        // TODO addbtn onclicklistener to add liqueurs on database
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindowAddBtn();
            }
        });

        // TODO create adapter for liquor item list view 1:15 in video


    }

    private void showPopupWindowListItem() {
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

        // TODO functionalities of textViews and editViews

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }

    private void showPopupWindowAddBtn(){
        View view = View.inflate(this, R.layout.liquor_add_popup,null);

        //
        EditText edtname = view.findViewById(R.id.editTextName);
        EditText edtmaxNumOfB = view.findViewById(R.id.editTextMaxNumB);
        EditText edtmaxCurOfB = view.findViewById(R.id.editTextCurNumB);
        Button add = view.findViewById(R.id.addbtn2);
        // TODO all view for liquorpopup layout abd their funcctionalities

        //
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(view ,width, height, false);
        //

        popupWindow.showAtLocation(lAct_parent, Gravity.CENTER,0,0);

        // TODO functionalities of textViews and editViews

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO add entry to database

                popupWindow.dismiss();
            }
        });
    }
}