package com.company;

class dining
{
    public static void main(String args[])
    {
        System.out.println("Starting the Dining Philosophers Simulation\n");
        miscsubs.InitializeChecking();
        // Your code here...
        Philosopher[] P = new Philosopher[miscsubs.NUMBER_PHILOSOPHERS];
//        miscsubs.StartEating(3);
        for(int i = 0; i < P.length; i++) {
            P[i] = new Philosopher(i);
        }
        P[0].run();
        P[1].run();
        P[2].run();
        P[3].run();
        P[4].run();


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
