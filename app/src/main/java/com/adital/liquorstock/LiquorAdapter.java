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

public class LiquorAdapter extends ArrayAdapter<Liquor> {
    public LiquorAdapter(@NonNull Context context, ArrayList<Liquor> liquorArrayList) {
        super(context,0, liquorArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView  = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.liquor_item, parent, false);
        }

        Liquor liquor = getItem(position);
        TextView liquorTV = listitemView.findViewById(R.id.idTVliquor);
        ImageView liquorIV = listitemView.findViewById(R.id.idIVliquor);

        liquorTV.setText(liquor.getLiquor_name());
        liquorIV.setImageResource(liquor.getImg_id());
        return listitemView;
    }
}
