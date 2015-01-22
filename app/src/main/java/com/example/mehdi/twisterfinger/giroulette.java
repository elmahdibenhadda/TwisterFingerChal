package com.example.mehdi.twisterfinger;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;


public class giroulette extends ActionBarActivity {
    private float from = 27f;
    private float to = 27 + 360;// 3.141592654f * 32.0f;
    ImageView favicon;
    String couleur="jaune";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giroulette);

        favicon = (ImageView) findViewById(R.id.imageView);
        Button buton1 = (Button) findViewById(R.id.button);
        Button buton2 = (Button) findViewById(R.id.button2);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action1();
            }
        });


        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action2();
            }
        });


    }

    private void action1() {


    }

    private void action2() {
        Random rand = new Random();

        int randomNum = rand.nextInt((16 - 1) + 1) + 1;

        //entre 18 et 30
        to = randomNum * 90;
        switch (randomNum % 4) {
            case 1:

                    Log.e("couleur", "rouge");

                break;
            case 2:

                    Log.e("couleur", "vert");

                break;
            case 3:

                    Log.e("couleur", "bleu");

                break;
            default:

                    Log.e("couleur", "jaune");

                break;
        }
        Log.e("action2", "from to random " + randomNum);
        RotateAnimation r; // = new RotateAnimation(ROTATE_FROM, ROTATE_TO);

        r = new RotateAnimation(from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        Log.e("action2", " to" + to + "modulo " + randomNum % 4 + " from" + from);
        r.setDuration((long) 4000);
        r.setRepeatCount(0);
        r.setFillEnabled(true);
        r.setFillAfter(true);
        favicon.startAnimation(r);
        r.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Random rand = new Random();

                // nextInt is normally exclusive of the top value,
                // so add 1 to make it inclusive

                from = to;


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giroulette, menu);
        return true;
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

    String getCouleurSuivante(String couleur) {
        if (couleur == "rouge")
            return "vert";
        if (couleur == "vert")
            return "bleu";
        if (couleur == "bleu")
            return "jaune";
        if (couleur == "jaune")
            return "rouge";
        return"none";
    }
    String getCouleurPrecedante(String couleur) {
        if (couleur == "vert")
            return "rouge";
        if (couleur == "bleu")
            return "vert";
        if (couleur == "jaune")
            return "bleu";
        if (couleur == "rouge")
            return "jaune";
        return"none";
    }
}
