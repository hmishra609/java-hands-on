package org.example.threads;

public class NThreadCoordination {
    static void main() {
        for (int i = 1; i <= 5; i++) {
            Thread thread= new Thread(new PrintSequencialNumber(i));
            thread.start();

        }
    }


}

class PrintSequencialNumber implements Runnable {

    static final int NUM_OF_THREADS = 5;
    static final int NUM_MAX = 100;
    private final int threadId;

    public static volatile int counter=1;
    static final Object lock = new Object();

    PrintSequencialNumber(int threadId) {
        this.threadId = threadId;
    }

    public void run() {
        while (counter <= NUM_MAX) {
            synchronized (lock) {
                // the one
                while (counter <= NUM_MAX && counter % NUM_OF_THREADS != threadId % NUM_OF_THREADS) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }

                if (counter <= NUM_MAX) {
                    System.out.println("Thread " + threadId + ": " + counter);
                    counter++;
                    lock.notifyAll();
                }


            }
        }
    }
}
