package com.example.android.deutscheslager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_layout);

        final ArrayList<Word> c_words = new ArrayList<Word>();
        c_words.add(new Word("Auf dem Weg", "On the way", R.raw.sound_1));




        WordAdapter itemsAdapter = new WordAdapter(this, c_words, R.color.fadeYellow);

        ListView listView = (ListView) findViewById(R.id.one_layout);

        listView.setAdapter(itemsAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = c_words.get(i);
                MediaPlayer newMedia = MediaPlayer.create(PhrasesActivity.this, word.getAudioRes());
                newMedia.start();

            }
        });

    }
}
