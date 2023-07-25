package com.adital.liquorstock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Liquor list adapter.
 *
 * @author Thomas Pliakis
 * @version 1.0
 * @since 2023-07-23
 */
public class LiquorListAdapter extends ArrayAdapter<LiquorModel> {
    public LiquorListAdapter(@NonNull Context context, ArrayList<LiquorModel> liquorArrayList) {
        super(context,0, liquorArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemLiquor = convertView;
        if (listItemLiquor == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemLiquor = LayoutInflater.from(getContext()).inflate(R.layout.liquor_list_items, parent, false);
        }

        LiquorModel liquorModel = getItem(position);
        TextView liquorModelTV = listItemLiquor.findViewById(R.id.liquorName);
        TextView liquorModelIV = listItemLiquor.findViewById(R.id.liquorCurNumOfBottles);

        liquorModelTV.setText(liquorModel.getName());
        liquorModelIV.setText(Integer.toString(liquorModel.getCurNumOfBottles()));
        return listItemLiquor;
    }
}
