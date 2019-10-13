WorkManager is a library used to enqueue deferrable work that is guaranteed to execute sometime after its Constraints are met. WorkManager allows observation of work status and the ability to create complex chains of work.

WorkManager uses an underlying job dispatching service when available based on the following criteria:

    Uses JobScheduler for API 23+
    Uses a custom AlarmManager + BroadcastReceiver implementation for API 14-22

All work must be done in a ListenableWorker class. A simple implementation, Worker, is recommended as the starting point for most developers. With the optional dependencies, you can also use CoroutineWorker or RxWorker. All background work is given a maximum of ten minutes to finish its execution. After this time has expired, the worker will be signalled to stop. 

References
https://developer.android.com/reference/androidx/work/WorkManager
