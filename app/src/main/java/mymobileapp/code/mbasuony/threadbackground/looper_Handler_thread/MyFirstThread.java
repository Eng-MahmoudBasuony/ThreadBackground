package mymobileapp.code.mbasuony.threadbackground.looper_Handler_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import mymobileapp.code.mbasuony.threadbackground.Constant;

//this Custom Thread
public class MyFirstThread extends Thread
{
    private Handler mMainThreadHandler=null;  // potential to leak memory.
    private boolean isRunning=false;         // to determine if running or not, helps us to avoid memory leaks.
    private CustomHandler mCustomHandler;


    public MyFirstThread(Handler mainHandler)
    {
        mMainThreadHandler=mainHandler;
        isRunning=true;                   //When Threading is Create the Thread is Active
    }

    @Override
    public void run()
    {
        super.run();

        if (isRunning)
        {
            Looper.prepare(); //Initialized or prepare for Looper
            mCustomHandler=new CustomHandler(Looper.myLooper()); // return the looper for this thread
            Looper.loop(); //start looping our loop
        }


    }




    /**this Method to receive any Message from any "Activity" then Send to "CustomHandler"
    * */
    public void sendMessageToFirstThread(Message message)
    {

        while (true)
        {
            try
            {
                mCustomHandler.sendMessage(message); //to method "handleMessage(Message msg)"
                break;
            }
            catch (NullPointerException e)
            {
                Log.d("TAG1", "sendMessageToFirstThread: " + e.getMessage());

                try    // Sometime threads has delay to start immediately,
                {     // therefore we should try to catch that null error.
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }
        }
    }

     // post our runnable to this custom thread.
    public void sendRunnableToFirstThread(Runnable runnable)
    {
        // Sometime threads has delay to start immediately,
        // therefore we should try to catch that null error.
        while (true)
        {
            try
            {
                mCustomHandler.post(runnable);
                break;
            } catch (NullPointerException e)
            {
                Log.d("TAG2", "sendMessageToFirstThread: " + e.getMessage());
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
    }


    /** stop this Thread :
     * "stop this message and clear it,* so no memory leaks"
     * */
    public void quit()
    {
        isRunning = false;
        mMainThreadHandler = null;
    }



/**
  * CustomHandler class for this thread.
  * A handler takes the messages, receives the messages, carries the messages.
*/
public class CustomHandler extends Handler
 {

public CustomHandler(Looper looper)
{
    super(looper);
}
    // We put our heavy code that we want to runs on background here. Like room insert, update, query, delete.
    @Override
    public void handleMessage(Message msg)
    {
        if (msg.what == Constant.MULTIPLICATION_TASK)
        {
            Log.d("TAG", "handleMessage: Calculating... 10 * 90 from thread: " + Thread.currentThread().getName());

            // Task
            int x = 10;
            int y = 90;
            int result = y * x;


            // Prepare result onto a bundle to send it back to main thread
            Message message = Message.obtain(null, Constant.MULTIPLICATION_TASK);

            Bundle bundle = new Bundle();
            bundle.putInt(Constant.RESULT_KEY, result);

            message.setData(bundle);

            mMainThreadHandler.sendMessage(message);
        }

        if (msg.what == Constant.ADDITION_TASK)
        {

        }
    }
}








}
