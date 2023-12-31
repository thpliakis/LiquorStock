package com.adital.liquorstock;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Liquor activity.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */

public class LiquorActivity extends AppCompatActivity {

    ConstraintLayout lAct_parent;
    private ListView liquorslistLW;
    private ImageButton addBtn;
    private  String liquorType;
    LiquorListAdapter adapter;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquor);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            liquorType = extras.getString("liquorType");
        }

        //TextView liqBar = findViewById(R.id.liquorsBar);
        //liqBar.setText(liquorType);
        lAct_parent = findViewById(R.id.lAct_parent);
        liquorslistLW = findViewById(R.id.liquorsList);
        addBtn = findViewById(R.id.addbtn);

        // Fetch the list of liqueurs
        dataBaseHelper = new DataBaseHelper(LiquorActivity.this);
        try{
            // Adapter for listView
            showLiqueursOnListView(LiquorActivity.this); // Show listView with liquorListAdapter
        }catch (Exception e){
            Toast.makeText(LiquorActivity.this, "something is wrong", Toast.LENGTH_SHORT).show();
        }


        // Clicking on a item in the list.

        liquorslistLW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //showPopupWindowListItem(adapter.getItem(i).getId());
                showPopupWindowListItem(i);
                //liquorslistLW.invalidateViews();
                //showLiqueursOnListView(LiquorActivity.this);
            }
        });


        // TODO addbtn onclicklistener to add liqueurs on database
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    //Toast.makeText(LiquorActivity.this, liquorType, Toast.LENGTH_LONG).show();
                    showPopupWindowAddBtn();
                    //showLiqueursOnListView(LiquorActivity.this);

                }catch (Exception e){

                    Toast.makeText(LiquorActivity.this, "something is wrong", Toast.LENGTH_LONG).show();
                }
                //showPopupWindowAddBtn();

            }
        });

        // TODO create adapter for liquor item list view 1:15 in video

    }

    private void showLiqueursOnListView(LiquorActivity context) {
        adapter = new LiquorListAdapter(context, dataBaseHelper.getLiquorList(liquorType));
        liquorslistLW.setAdapter(adapter);
    }

    private void showPopupWindowListItem(int i) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.liquor_popup, null);


        // create the popup window
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
        popupWindow.setElevation(20);
        //
        TextView name = popupView.findViewById(R.id.liqNamePopup);
        //TextView maxStock = view.findViewById(R.id.maxStock);
        //TextView curStoc = view.findViewById(R.id.curStock);
        //EditText edtMaxStock = popupView.findViewById(R.id.numMaxStock);
       // EditText edtCurStock = popupView.findViewById(R.id.numCurStock);
        final Button done = popupView.findViewById(R.id.btnDone);
        ImageButton dltbtn = popupView.findViewById(R.id.dltbtn);
        //

        name.setText(adapter.getItem(i).getName());
       // edtMaxStock.setHint(adapter.getItem(i).getMaxNumOfBottles());
        //edtCurStock.setHint(adapter.getItem(i).getCurNumOfBottles());
        //int ems = parseInt(edtMaxStock.getText().toString());
       // int ecs = parseInt(edtCurStock.getText().toString());

       // edtMaxStock.setHint(ems);
      //  edtCurStock.setHint(ecs);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // TODO notify changes
;

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });


        //add to database
        dltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindowConfirmation(i);
                popupWindow.dismiss();
            }
        });

    }

    private void showPopupWindowConfirmation(int i){

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.dlt_confirmation_popup, null);


        // create the popup window
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
        popupWindow.setElevation(20);
        Button y = popupView.findViewById(R.id.yesbtn);
        Button n = popupView.findViewById(R.id.nobtn);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteLiquor(adapter.getItem(i));
                showLiqueursOnListView(LiquorActivity.this);
                popupWindow.dismiss();
            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do nothing
                popupWindow.dismiss();
            }
        });
    }

    private void showPopupWindowAddBtn(){
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.liquor_add_popup, null);


        // create the popup window
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView,width,height,focusable);
        popupWindow.setElevation(20);
        EditText edtname = popupView.findViewById(R.id.editTextName);
        EditText edtmaxNumOfB = popupView.findViewById(R.id.editTextMaxNumB);
        EditText edtCurOfB = popupView.findViewById(R.id.editTextCurNumB);
        final Button add = (Button) popupView.findViewById(R.id.addbtn2);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // add a liquor at database
        add.setOnClickListener(view -> {
            // TODO add entry to database
            dataBaseHelper.addLiquorItem(new LiquorModel(edtname.getText().toString(), liquorType));
            showLiqueursOnListView(LiquorActivity.this);
        });

        /*
        View view = View.inflate(this, R.layout.liquor_add_popup,null);

        //
        EditText edtname = view.findViewById(R.id.editTextName);
        EditText edtmaxNumOfB = view.findViewById(R.id.editTextMaxNumB);
        EditText edtCurOfB = view.findViewById(R.id.editTextCurNumB);
        Button add = view.findViewById(R.id.addbtn2);


        String liqName = edtname.getText().toString();
        int maxNB = parseInt(edtmaxNumOfB.getText().toString());
        int curNB = parseInt(edtCurOfB.getText().toString());

        //
        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        PopupWindow popupWindow = new PopupWindow(view ,width, height, false);
        //

        popupWindow.showAtLocation(lAct_parent, Gravity.CENTER,0,0);

        // TODO notify changes?

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO add entry to database
                dataBaseHelper.addLiquorItem(new LiquorModel(liqName, liquorType));
                popupWindow.dismiss();
            }
        });
        */
    }
}