package com.company;

class dining
{
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting the Dining Philosophers Simulation\n");
        miscsubs.InitializeChecking();
        // Your code here...
        Philosopher[] P = new Philosopher[miscsubs.NUMBER_PHILOSOPHERS];
        Thread[] threads = new Thread[miscsubs.NUMBER_PHILOSOPHERS];
        for(int i = 0; i < miscsubs.NUMBER_PHILOSOPHERS; i++) {
            P[i] = new Philosopher(i);
        }

        for(int j = 0; j < P.length; j++){
            threads[j] = new Thread(P[j]);
            threads[j].start();
        }
        for(int l = 0; l < threads.length; l++){
            threads[l].join();
        }

        // End of your code
        miscsubs.LogResults();
    }
}
