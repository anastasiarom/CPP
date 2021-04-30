package com.example.demo.counter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CounterThread extends Thread {

    Logger logger = LogManager.getLogger(CounterThread.class);

    public CounterThread() {
        super();
        start();
    }

    public void run() {
        while (Thread.currentThread().getName().equals("Thread-1")) {
            try {
                logger.info(Thread.currentThread().getName() + " is waiting for resolution");
                Synchronization.semaphore.acquire();
                Counter.increment();
                logger.info("Counter after increment " + Counter.getCount());
            } catch (InterruptedException e) {
                logger.error("Interrupting a thread");
            }
        }
    }
}
