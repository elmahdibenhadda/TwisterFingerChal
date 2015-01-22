package com.example.mehdi.twisterfinger;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.mehdi.twisterfinger.beans.Rond;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private float from = 27f;
    private float to = 27 + 360;// 3.141592654f * 32.0f;
    ImageView favicon;
    String couleur="jaune";
 private List<Rond> listRond;
private Rond mylocalRond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circles_layout);
        addButtonToList();

        for(Rond rond :listRond) {

            rond.getImageViewRond().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP: {
                            Log.e("UP", "UP");
                           v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                           updateView((ImageView) v);
                        }
                        break;
                        case MotionEvent.ACTION_DOWN: {
                            Log.e("Down", "Down");
                            v.setBackgroundColor(Color.GRAY);

                        }
                        break;

                    }
                    return true;
                }

            });
        }





        favicon = (ImageView) findViewById(R.id.imageView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void addButtonToList() {
listRond=new ArrayList<>();
        Rond blue1=new Rond((ImageView)findViewById(R.id.blue1),"blue","1");
        Rond blue2=new Rond((ImageView)findViewById(R.id.blue2),"blue","2");
        Rond blue3=new Rond((ImageView)findViewById(R.id.blue3),"blue","3");
        Rond blue4=new Rond((ImageView)findViewById(R.id.blue4),"blue","4");

        Rond jaune1=new Rond((ImageView)findViewById(R.id.jaune1),"jaune","1");
        Rond jaune2=new Rond((ImageView)findViewById(R.id.jaune2),"jaune","2");
        Rond jaune3=new Rond((ImageView)findViewById(R.id.jaune3),"jaune","3");
        Rond jaune4=new Rond((ImageView)findViewById(R.id.jaune4),"jaune","4");

        Rond rouge1=new Rond((ImageView)findViewById(R.id.rouge1),"rouge","1");
        Rond rouge2=new Rond((ImageView)findViewById(R.id.rouge2),"rouge","2");
        Rond rouge3=new Rond((ImageView)findViewById(R.id.rouge3),"rouge","3");
        Rond rouge4=new Rond((ImageView)findViewById(R.id.rouge4),"rouge","4");

        Rond vert1=new Rond((ImageView)findViewById(R.id.vert1),"vert","1");
        Rond vert2=new Rond((ImageView)findViewById(R.id.vert2),"vert","2");
        Rond vert3=new Rond((ImageView)findViewById(R.id.vert3),"vert","3");
        Rond vert4=new Rond((ImageView)findViewById(R.id.vert4),"vert","4");

        listRond.add(blue1);
        listRond.add(blue2);
        listRond.add(blue3);
        listRond.add(blue4);
        listRond.add(vert1);
        listRond.add(vert2);
        listRond.add(vert3);
        listRond.add(vert4);
        listRond.add(jaune1);
        listRond.add(jaune2);
        listRond.add(jaune3);
        listRond.add(jaune4);
        listRond.add(rouge1);
        listRond.add(rouge2);
        listRond.add(rouge3);
        listRond.add(rouge4);
    }


   public void updateView(ImageView view){
for(Rond rond : listRond)
{
    if(view.equals(rond.getImageViewRond()))
    {

        //traitement
    }
}
   };
}
