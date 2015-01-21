package com.example.mehdi.twisterfinger;

import android.content.Context;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.mehdi.twisterfinger.sound.SoundMetter;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btnJouer = null;
    private EditText joueurs;
    private EditText doits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnJouer = (Button) findViewById(R.id.Jouer);
        doits = (EditText) findViewById(R.id.nbrFingersEdit);
        joueurs = (EditText) findViewById(R.id.nbrGamersEdit);

        btnJouer.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("joueurs", Integer.parseInt(joueurs.getText().toString()));
        intent.putExtra("doits",Integer.parseInt( doits.getText().toString()));
        startActivity(intent);

    }
}
