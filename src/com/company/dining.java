package com.company;

class dining
{
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Starting the Dining Philosophers Simulation\n");
        miscsubs.InitializeChecking();
        // Your code here...
        Philosopher[] P = new Philosopher[miscsubs.NUMBER_PHILOSOPHERS];
        Thread[] threads = new Thread[miscsubs.NUMBER_PHILOSOPHERS];
//        miscsubs.StartEating(3);
        for(int i = 0; i < miscsubs.NUMBER_PHILOSOPHERS; i++) {
            P[i] = new Philosopher(i);
        }
        for(int i = 0; i < miscsubs.NUMBER_PHILOSOPHERS; i++){
            threads[i] = new Thread(P[i]);
        }
        while(miscsubs.MAX_EATS > miscsubs.TotalEats){
            for(int i = 0; i < threads.length; i++) {
                threads[i].start();
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
