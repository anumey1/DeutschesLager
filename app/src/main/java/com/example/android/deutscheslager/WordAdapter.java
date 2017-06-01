package com.example.android.deutscheslager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//import android.support.annotation.NonNull;

//import android.support.annotation.NonNull;
//import android.widget.ImageView;


/**
 * Created by Anumey Sharma on 26-Dec-16.
 */

public class WordAdapter extends ArrayAdapter<Word>{


    private int c_resource;


    public WordAdapter(Activity context, ArrayList<Word> n_word, int cResource){

        super(context, 0, n_word);

        c_resource = cResource;



    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_batches, parent, false);
        }


        Word currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_text1);

        nameTextView.setText(currentWord.getEnglish());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.list_text2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDeutsch());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.android_image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if (currentWord.hasImage()) {


            iconView.setImageResource(currentWord.getResource());
            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            iconView.setVisibility(View.VISIBLE);
        }

        else{
            iconView.setVisibility(View.GONE);
        }









        View textCon = listItemView.findViewById(R.id.list_item_bitches);

        int color = ContextCompat.getColor(getContext(), c_resource);

        textCon.setBackgroundColor(color);

        return listItemView;









        //return super.getView(position, convertView, parent);



    }
}
