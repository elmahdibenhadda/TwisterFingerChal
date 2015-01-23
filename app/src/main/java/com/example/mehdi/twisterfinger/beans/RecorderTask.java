package com.example.mehdi.twisterfinger.beans;

import android.util.Log;
import android.widget.ImageView;

import com.example.mehdi.twisterfinger.sound.SoundMetter;

import java.util.TimerTask;

/**
 * Created by mehdi on 22/01/2015.
 */
public class RecorderTask extends TimerTask {
    private SoundMetter recorder;
    private ImageView roulette;

    private int flagTest=0;

    public RecorderTask(SoundMetter recorder) {
        this.recorder = recorder;
        flagTest=0;
        this.recorder.start();

    }

    public void run() {

        if(recorder.getAmplitude() > 7){
            flagTest=1;
        }else{

            flagTest=0;
        }
        }

    public int getFlagTest() {
        return flagTest;
    }

    public void setFlagTest(int flagTest) {
        this.flagTest = flagTest;
    }

    public void stop() {
        this.recorder.stop();
    }

}
