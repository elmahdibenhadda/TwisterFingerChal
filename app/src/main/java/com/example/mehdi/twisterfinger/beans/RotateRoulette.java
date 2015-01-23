package com.example.mehdi.twisterfinger.beans;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.mehdi.twisterfinger.roulette.Colors;
import com.example.mehdi.twisterfinger.roulette.TheGame;

import java.util.Random;

/**
 * Created by mehdi on 22/01/2015.
 */
public class RotateRoulette {

    private ImageView roulette;
    private float from = 27f;
    private float to = 27 + 360;
    private Colors couleur;

    public RotateRoulette(ImageView roulette) {
        this.roulette = roulette;
    }

    public ImageView getRoulette() {
        return roulette;
    }

    public void setRoulette(ImageView roulette) {
        this.roulette = roulette;
    }

    public void rotate(){
        Random rand = new Random();

        int randomNum = rand.nextInt((16 - 1) + 1) + 1;

        //entre 18 et 30
        to = randomNum * 90;
        switch (randomNum % 4) {
            case 1:

                Log.e("couleur", "rouge");
couleur=Colors.RED;
                break;
            case 2:

                Log.e("couleur", "vert");
                couleur=Colors.GREEN;
                break;
            case 3:
                couleur=Colors.BLUE;
                Log.e("couleur", "bleu");

                break;
            default:
                couleur=Colors.YELLOW;
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
        roulette.startAnimation(r);
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
                from = to;


            }
        });


    }
}
