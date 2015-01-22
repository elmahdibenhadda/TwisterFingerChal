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


public class MainActivity extends ActionBarActivity {
    ImageView blue1;
    ImageView vert2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circles_layout);
        blue1=(ImageView) findViewById(R.id.blue1);
        vert2=(ImageView) findViewById(R.id.vert2);
        blue1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                    {
                        Log.e("UP", "UP");
                        blue1.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    }break;
                    case MotionEvent.ACTION_DOWN:
                    {
                        Log.e("Down","Down");
                        blue1.setBackgroundColor(Color.GRAY);

                    }break;

                }
                return true;
            }

        });

        vert2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                    {
                        Log.e("UP", "UP");
                        vert2.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    }break;
                    case MotionEvent.ACTION_DOWN:
                    {
                        Log.e("Down","Down");
                        vert2.setBackgroundColor(Color.GRAY);

                    }break;

                }
                return true;
            }

        });
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
}
