package com.example.android.deutscheslager;

/**
 * Created by Anumey Sharma on 26-Dec-16.
 */

public class Word {

    private String mEnglish;
    private String mDeutsch;
    private int mResource = no_image_provided;
    public static final int no_image_provided = -1;
    private int mAudioRes;

    public Word(String Deutsch, String English, int resource, int audioRes){
        mEnglish = English;
        mDeutsch = Deutsch;
        mResource = resource;
        mAudioRes = audioRes;
    }

    public Word(String Deutsch, String English, int audioRes){
        mEnglish = English;
        mDeutsch = Deutsch;
        mAudioRes = audioRes;

    }

    public String getEnglish(){return mEnglish; }

    public String getDeutsch(){return mDeutsch; }

    public int getResource(){return mResource; }

    public boolean hasImage(){
        return mResource != no_image_provided;

    }

    public int getAudioRes(){return mAudioRes; }


}
