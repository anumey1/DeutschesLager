package com.example.android.deutscheslager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        TextView colors = (TextView) findViewById(R.id.d_colors);
        TextView food = (TextView) findViewById(R.id.d_food);
        TextView general = (TextView) findViewById(R.id.d_general);
        TextView number = (TextView) findViewById(R.id.d_numbers);
        TextView phrases = (TextView) findViewById(R.id.d_phrases);
        TextView profanity = (TextView) findViewById(R.id.d_profanity);



        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);

            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GeneralActivity.class);
                startActivity(i);
            }
        });

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(i);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(i);
            }
        });

        profanity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfanityActivity.class);
                startActivity(i);
            }
        });



    }












    /*

    public void open_numbers(View view){
        Intent intent = new Intent(this,NumbersActivity.class);
        startActivity(intent);


    }


    public void open_profanity(View view){
        Intent intent = new Intent(this,ProfanityActivity.class);
        startActivity(intent);


    }


    public void open_phrases(View view){
        Intent intent = new Intent(this,PhrasesActivity.class);
        startActivity(intent);


    }


    public void open_general(View view){
        Intent intent = new Intent(this,GeneralActivity.class);
        startActivity(intent);


    }


    public void open_food(View view){
        Intent intent = new Intent(this,FoodActivity.class);
        startActivity(intent);


    }


    public void open_colors(View view){
        Intent intent = new Intent(this,ColorsActivity.class);
        startActivity(intent);


    }*/


}
