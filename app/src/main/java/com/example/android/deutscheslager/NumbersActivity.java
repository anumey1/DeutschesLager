package com.example.android.deutscheslager;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer newMedia;
    private AudioManager audioMan;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();


                    } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                        newMedia.pause();
                    } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                        newMedia.pause();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        newMedia.start();
                    }
                }
            };


    private MediaPlayer.OnCompletionListener mComplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }  };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_layout);

        audioMan = (AudioManager) getSystemService(this.AUDIO_SERVICE);

        final ArrayList<Word> n_words = new ArrayList<Word>();
        n_words.add(new Word("Null", "Zero", R.drawable.analytics, R.raw.sound_1));
        n_words.add(new Word("Eins", "One", R.drawable.archives, R.raw.sound_2));
        n_words.add(new Word("Zwei", "Two", R.drawable.businessman, R.raw.sound_1));
        n_words.add(new Word("Drei", "Three", R.drawable.certificate, R.raw.sound_2));
        n_words.add(new Word("Vier", "Four", R.drawable.chat, R.raw.sound_1));
        n_words.add(new Word("Funf", "Five", R.drawable.contract, R.raw.sound_2));
        n_words.add(new Word("Sechs", "Six", R.drawable.curriculum, R.raw.sound_1));
        n_words.add(new Word("Sieben", "Seven", R.drawable.curriculum, R.raw.sound_2));
        n_words.add(new Word("Acht", "Eight", R.drawable.chat, R.raw.sound_1));
        n_words.add(new Word("Neun", "Nine", R.drawable.businessman, R.raw.sound_2));
        n_words.add(new Word("Zehn", "Ten", R.drawable.curriculum, R.raw.sound_1));
        n_words.add(new Word("Elf", "Eleven", R.drawable.archives, R.raw.sound_2));
        n_words.add(new Word("Zwolf", "Twelve", R.drawable.chat, R.raw.sound_1));
        n_words.add(new Word("Dreizehn", "Thirteen", R.drawable.businessman, R.raw.sound_2));
        n_words.add(new Word("Vierzehn", "Fourteen", R.drawable.curriculum, R.raw.sound_1));
        n_words.add(new Word("Funfzehn", "Fifteen", R.drawable.archives, R.raw.sound_2));
        n_words.add(new Word("Sechzehn", "Sixteen", R.drawable.chat, R.raw.sound_1));
        n_words.add(new Word("Siebzehn", "Seventeen", R.drawable.businessman, R.raw.sound_2));
        n_words.add(new Word("Achtzehn", "Eighteen", R.drawable.curriculum, R.raw.sound_1));
        n_words.add(new Word("Neunzehn", "Nineteen", R.drawable.chat, R.raw.sound_2));
        n_words.add(new Word("Zwanzig", "Twenty", R.drawable.businessman, R.raw.sound_1));


        WordAdapter itemsAdapter = new WordAdapter(this, n_words, R.color.fadeYellow);

        ListView listView = (ListView) findViewById(R.id.one_layout);

        listView.setAdapter(itemsAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = n_words.get(i);

                releaseMediaPlayer();

                // Request audio focus for playback
                int result = audioMan.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // Start playback


                    newMedia = MediaPlayer.create(NumbersActivity.this, word.getAudioRes());
                    newMedia.start();

                    newMedia.setOnCompletionListener(mComplete);

                }


            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (newMedia != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            newMedia.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            newMedia = null;

            audioMan.abandonAudioFocus(afChangeListener);
        }
    }


}
