package mymobileapp.code.mbasuony.threadbackground;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread.MyFirstThread;

public class MainActivity extends AppCompatActivity implements Handler.Callback
{

    private static final String TAG = "Main2Activity";

    private MyFirstThread mMyFirstThread;
    private Handler mMainThreadHandler = null;

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
                // Create a message and send it to the background custom thread
                Message message = Message.obtain(null, Constant.MULTIPLICATION_TASK);
                mMyFirstThread.sendMessageToFirstThread(message);

                Runnable runnable = new Runnable()
                {
                    @Override
                    public void run()
                    {
                        // Task
                        int x = 10;
                        int y = 90;
                        Log.d(TAG, "run: a Runnable Calculating... 90 - 10 from thread: " + Thread.currentThread().getName());

                        int result = y - x;
                        Log.d(TAG, "run: Result ... 90 - 10 " + result + " from thread: " + Thread.currentThread().getName());
                    }
                };

                mMyFirstThread.sendRunnableToFirstThread(runnable);
    }});

        // Init Handler
        mMainThreadHandler = new Handler(this);
    }

    private void initialView()
    {
        fab1=findViewById(R.id.floating_button1);
    }


    @Override
    public boolean handleMessage(Message msg)
    {
        if (msg.what == Constant.MULTIPLICATION_TASK)
        {
            int result = msg.getData().getInt(Constant.RESULT_KEY, -1);

            Log.d(TAG, "handleMessage: Result... " + result + " from thread: " + Thread.currentThread().getName());
        }

        if (msg.what == Constant.ADDITION_TASK)
        {
            Log.d(TAG, "handleMessage: Result... " + Thread.currentThread().getName());
        }

        return false;
    }



    @Override
    protected void onStart()
    {
        super.onStart();
        mMyFirstThread = new MyFirstThread(mMainThreadHandler);
        mMyFirstThread.start();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mMyFirstThread.quit();
    }


}
