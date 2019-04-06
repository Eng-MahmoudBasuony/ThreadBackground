# Android Project for variety of patterns that shows how to implements and deal with background tasks in Android.
# Thread Patterns (Concurrency)

 ###   Looper, Handler ,Thread Pattern
  > Package name "looper_Handler_threadThread" Dedicated for--> Thread ,Looper, Handler Pattern (ActivityLHT.java, MyFirstThread.java). run in ActivityLHT by Button btn1

Use it
   * Run code based on message sent from MainThread to Custom Thread
   
The disadvantages of this Pattern :
  * It needs to create many programming lines.
  * This pattern is not LifeCycle Aware so any error in its application causes Memory Leaks.
   

