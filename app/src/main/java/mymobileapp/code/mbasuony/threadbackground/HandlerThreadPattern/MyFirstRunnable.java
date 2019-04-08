package mymobileapp.code.mbasuony.threadbackground.HandlerThreadPattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

import mymobileapp.code.mbasuony.threadbackground.Constant;


public class MyFirstRunnable implements Runnable
{

    private WeakReference<Handler>mMainThreadHandler;
    private static final String TAG = "MyFirstRunnable";


    public MyFirstRunnable(Handler handlerMainThread)
    {
        mMainThreadHandler=new WeakReference<>(handlerMainThread);
    }


    @Override
    public void run()
    {
        Message message = Message.obtain(null, Constant.ADDITION_TASK);

        int x = 10;
        int y = 10;
        int result = x + y;
        Log.d(TAG, "run: Calculating... 10 + 10 from thread: " + Thread.currentThread().getName());

        Bundle bundle = new Bundle();
        bundle.putInt(Constant.RESULT_KEY, result);
        message.setData(bundle);

        mMainThreadHandler.get().sendMessage(message); // we used get() because it is weak reference.
    }


}
