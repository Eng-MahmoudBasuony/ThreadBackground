package mymobileapp.code.mbasuony.threadbackground;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread.ActivityLHT;
import mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread.MyFirstThread;

public class MainActivity extends AppCompatActivity
{

    private FloatingActionButton fab1; // this Button for Run Pattern (Looper-Handler-Thread)

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();

        fab1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(MainActivity.this, ActivityLHT.class);
                      startActivity(i);
             }});


    }

    private void initialView()
    {
        fab1=findViewById(R.id.floating_button1);
    }



}
