package com.company;

public class Philosopher implements Runnable {
    int id;
    public void run(){
        miscsubs.RandomDelay();
        try {
            CheckNeighbors(miscsubs.NUMBER_PHILOSOPHERS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        miscsubs.StartEating(id);
        miscsubs.RandomDelay();
        try {
            CheckNeighbors(miscsubs.NUMBER_PHILOSOPHERS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        miscsubs.DoneEating(id);
    }
    public Philosopher(int idNumber){
        this.id = idNumber;
    }
    public void CheckNeighbors(int numPhilosophers) throws InterruptedException {
        int leftNeighbor = (id == 0)? numPhilosophers-1: id--;
        int rightNeighbor = (id++) % numPhilosophers;
        if(miscsubs.EatingLog[leftNeighbor]){
            System.out.println("Philosopher " + id + " waiting on left stick");
            Thread.currentThread().sleep(1);
        }
        if(miscsubs.EatingLog[rightNeighbor]){
            System.out.println("Philosopher " + id + " waiting on right stick");
            Thread.currentThread().sleep(1);
        }
    }

}
