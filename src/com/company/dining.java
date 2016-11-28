package com.company;

class dining
{
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting the Dining Philosophers Simulation\n");
        miscsubs.InitializeChecking();
        // Your code here...
        Thread mainThread = new Thread();
        mainThread.start();
        Philosopher[] P = new Philosopher[miscsubs.NUMBER_PHILOSOPHERS];
        Thread[] threads = new Thread[miscsubs.NUMBER_PHILOSOPHERS];
//        miscsubs.StartEating(3);
        for(int i = 0; i < P.length; i++) {
            P[i] = new Philosopher(i);
        }
//        P[0].run();
//        P[1].run();
//        P[2].run();
//        P[3].run();
//        P[4].run();
        for(int i = 0; i < P.length; i++){
            threads[i] = new Thread(P[i]);
        }
        while(miscsubs.MAX_EATS > miscsubs.TotalEats){
            for(Thread thread: threads) {
                thread.join();
                thread.start();
            }
        }

//        while(miscsubs.TotalEats < miscsubs.MAX_EATS){
//            for(int i = 0; i < P.length; i++){
//                P[i].run();
//            }
//        }
//        miscsubs.DoneEating(3);
//        new Philosopher().run();

        // End of your code
        miscsubs.LogResults();
    }
}
