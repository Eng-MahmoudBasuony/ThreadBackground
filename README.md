# Android Project for variety of patterns that shows how to implements and deal with background tasks in Android.
# Thread Patterns (Concurrency)
-----------------------
 ###   Looper, Handler ,Thread Pattern
  > Package name "looper_Handler_threadThread" Dedicated for--> Thread ,Looper, Handler Pattern (ActivityLHT.java, MyFirstThread.java). run in ActivityLHT by Button btn1

* Use it
   * Run code based on message sent from MainThread to Custom Thread
   * Also there CallBack for Result
   
* The disadvantages of this Pattern :
   * It needs to create many programming lines.
   * This pattern is not LifeCycle Aware so any error in its application causes Memory Leaks.
   

* Steps Creation for MyFirstThread.java:

    0. Extend the class Thread.
    1. Create a handler field for Main Thread.
    2. Init it in the constructor.
    3. Create a custom handler inner class for this thread.
    4. Override handleMessage in the custom handler class, and put your work there"heavy code".
    5. Create a field for the custom handler.
    Running the Looper
    6. Override run() to prepare the Looper for this thread.
    7. Create a public method e.g. sendMessageToFirstThread() to retrieve messages into this thread.
    8. Create a public method e.g. quit() to stop this thread from other components, so no memory leaking.
   
* Steps Creation for ActivityLHT.java:

    1. Implement Handler.Callback.
    2. Override handleMessage().
    3. Create an instance field for MyFirstThread class.
    4. Create an instance field for a Handler.
    5. Init the Handler in onCreate().
    6. Override method onStart() and init the custom thread instance MyFirstThread.
    7. Override method onStop() and quit the custom thread instance MyFirstThread.
    Sending Task:
    8. Send your work to the background custom thread, here I used the fab button,
    otherwise onResume() after onStart() is good place.
    Retrieving Result:
    9. In handleMessage() retrieve your message from the custom thread and extract the result from it.
    
    ----------------------
   ### Handler Thread Pattern
   > Package name "HandlerThreadPattern" Dedicated for--> Runnable , Handler Pattern (ActivityHandlerPattern.java,    MyFirstRunnable.java). 
   
 * Steps Creation for ActivityHandlerPattern.java:
 
    1. Implement Handler.Callback.
    2. Override handleMessage().
    3. Create an instance field for HandlerThread.
    4. Create an instance field for a Handler to this main thread.
    5. Override method onStart() and init the HandlerThread and the MainThreadHandler.
    6. Override method onStop() and stop the HandlerThread.
    7. Create a handler for the background thread, with the help of HandlerThread.
    8. Post (send) your custom runnable into it.
   
   
* Steps Creation for MyFirstRunnable.java:
  
   1. Implement Runnable interface.
   2. Override run().
   3. Create field for main handler, using weak reference to avoid memory leaks.
   4. Do your work on run() then wrap result into the main thread handler, to send it to main thread.
  
    
