package com.example.mehdi.twisterfinger;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mehdi.twisterfinger.sound.SoundMetter;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends ActionBarActivity {

    private Button btnPlay = null;
    private Button btnStopSound = null;

    private MediaRecorder mRecorder = null;
    private Timer timer = null;
    //private RecorderTask recorderTask = null;
    private SoundMetter mngSound = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mngSound = new SoundMetter();



        btnPlay = (Button) findViewById(R.id.playButton);
        btnStopSound = (Button) findViewById(R.id.stopSound);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer = new Timer();
            //    recorderTask = new RecorderTask(mngSound);
              //  timer.scheduleAtFixedRate(recorderTask, 0, 1000);

                Toast.makeText(getApplicationContext(), "recording audio", Toast.LENGTH_LONG).show();
            }

        });

        btnStopSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("msg : ","CLICKED");
                vibrateOrSound();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void vibrateOrSound(){
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        MediaPlayer mediaPlayer = null;
        if(vib.hasVibrator()){
            vib.vibrate(500);//500ms
            Log.e("msg","hasVibrator");
        }
        else{
            mediaPlayer = MediaPlayer.create(this, R.raw.endgame);
            mediaPlayer.start();
            Log.e("msg","NO VIBer");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
/*
 class RecorderTask extends TimerTask {
    private SoundMetter recorder;

    public RecorderTask(SoundMetter recorder) {
        this.recorder = recorder;
        this.recorder.start();
    }

    public void run() {
        while(recorder.getAmplitude() > 7){
            // tournerLaRoulettePendant(Xsec);
            Log.e("msg : ","Catourne");
        }
        Log.i("", "amplitude is" + recorder.getAmplitude());
    }

     public void stop(){
         this.recorder.stop();
     }

}*/
