package com.example.android.deutscheslager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_layout);

        final ArrayList<Word> c_words = new ArrayList<Word>();
        c_words.add(new Word("Rot", "Red", R.raw.sound_1));
        c_words.add(new Word("Rosa", "Pink", R.raw.sound_1));
        c_words.add(new Word("Blau", "Blue", R.raw.sound_1));
        c_words.add(new Word("Grün", "Green", R.raw.sound_1));
        c_words.add(new Word("Gelb", "Yellow", R.raw.sound_1));
        c_words.add(new Word("Orange", "Orange", R.raw.sound_1));
        c_words.add(new Word("Braun", "Brown", R.raw.sound_1));
        c_words.add(new Word("Violett", "Violet", R.raw.sound_1));
        c_words.add(new Word("Weiß", "White", R.raw.sound_1));
        c_words.add(new Word("Schwarz", "Black", R.raw.sound_1));
        c_words.add(new Word("Grau", "Gray", R.raw.sound_1));
        c_words.add(new Word("Silber", "Silver", R.raw.sound_1));
        c_words.add(new Word("Gold", "Gold", R.raw.sound_1));



        WordAdapter itemsAdapter = new WordAdapter(this, c_words, R.color.fadeRed);

        ListView listView = (ListView) findViewById(R.id.one_layout);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = c_words.get(i);
                MediaPlayer newMedia = MediaPlayer.create(ColorsActivity.this, word.getAudioRes());
                newMedia.start();

            }
        });

    }
}
