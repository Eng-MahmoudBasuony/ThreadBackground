package mymobileapp.code.mbasuony.threadbackground;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mymobileapp.code.mbasuony.threadbackground.HandlerThreadPattern.ActivityHandlerPattern;
import mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread.ActivityLHT;
import mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread.MyFirstThread;

public class MainActivity extends AppCompatActivity
{



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    // this Method for open Pattern1 (Looper-Handler-Thread)
    public void openActivityPattern1(View view)
    {
        Intent i=new Intent(MainActivity.this, ActivityLHT.class);
        startActivity(i);
    }
    // this Method for open Pattern2 (Handler Thread)
    public void openActivityPattern2(View view)
    {
        Intent i=new Intent(MainActivity.this, ActivityHandlerPattern.class);
        startActivity(i);
    }









/*    public void Ganesh(View View)
    {
        String button_text;
        button_text =((Button)View).getText().toString();
        if(button_text.equals("click second activity"))
        {
            Intent ganesh = new Intent(this,SecondActivity.class);
            startActivity(ganesh);
        }
        else if (button_text.equals("click third activity"))
        {
            Intent mass = new Intent(this,ThirdActivity.class);
            startActivity(mass);

        }
    }*/

}
