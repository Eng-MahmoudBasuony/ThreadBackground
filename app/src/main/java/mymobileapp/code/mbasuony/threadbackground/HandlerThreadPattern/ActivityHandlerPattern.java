package mymobileapp.code.mbasuony.threadbackground.HandlerThreadPattern;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.IllegalFormatCodePointException;

import mymobileapp.code.mbasuony.threadbackground.Constant;
import mymobileapp.code.mbasuony.threadbackground.R;

public class ActivityHandlerPattern extends AppCompatActivity implements Handler.Callback
{

    private final static String TAG="ActivityHandler";
    private Button btn;
    private Handler mMainThreadHandler;
    private HandlerThread mHandlerThread;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_pattern);

          initialView();


          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v)
              {
                  Handler handler=new Handler(mHandlerThread.getLooper());

                     handler.post(new MyFirstRunnable(mMainThreadHandler));
              }
          });


    }

    private void initialView()
    {

        btn=findViewById(R.id.btn_HandlerActivity);
    }


    @Override
    public boolean handleMessage(Message msg)
    {

        if (msg.what== Constant.ADDITION_TASK)
        {
             int result=msg.getData().getInt(Constant.RESULT_KEY,-1);

            Log.d(TAG, "handleMessage: "+result);
        }

        return false;
    }


    @Override
    protected void onStart()
    {
        super.onStart();

        // Init a Handler for this thread
        mHandlerThread=new HandlerThread("BasuonyHandlerThread");
        mHandlerThread.start();

        mMainThreadHandler=new Handler(this);
    }

    @Override
    protected void onStop()
    {
        super.onStop();
       mHandlerThread.quit(); //stop Thread
    }

}
