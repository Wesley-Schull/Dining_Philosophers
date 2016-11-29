package com.company;

public class Philosopher implements Runnable {
    int id;
    public void run(){
//        System.out.print("Philosopher " + id + " thinking:\t");
        while(miscsubs.TotalEats < miscsubs.MAX_EATS) {
            miscsubs.RandomDelay();
            try {
                CheckNeighbors(miscsubs.NUMBER_PHILOSOPHERS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            miscsubs.StartEating(id);
//        System.out.print("Philosopher " + id + " eating:\t");
            miscsubs.RandomDelay();
            miscsubs.DoneEating(id);
            miscsubs.LogResults();
        }
    }
    public Philosopher(int idNumber){
        this.id = idNumber;
    }
    public synchronized void CheckNeighbors(int numPhilosophers) throws InterruptedException {
        int leftNeighbor = (id == 0)? numPhilosophers-1: id--;
        int rightNeighbor = (id++);// % numPhilosophers;


        while(miscsubs.EatingLog[leftNeighbor]){
            System.out.println("Philosopher " + id + " waiting on left stick");
            Thread.currentThread().sleep(10);
        }
        System.out.println("Philosopher " + id + " has left stick");
        while(miscsubs.EatingLog[rightNeighbor]){
            System.out.println("Philosopher " + id + " waiting on right stick");
            Thread.currentThread().sleep(10);
        }
        System.out.println("Philosopher " + id + " has right stick");
    }


}
