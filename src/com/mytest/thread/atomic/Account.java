package com.mytest.thread.atomic;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private int balance;

    private Lock l;

    private AtomicInteger failCounter;

    public Account(int initBalance) {
        this.balance = initBalance;
        l = new ReentrantLock();
        failCounter = new AtomicInteger(0);
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return l;
    }

    public void incFailedTransferCount()
    {
        failCounter.incrementAndGet();
    }

//    public int getFailCounter() {
//        return failCounter;
//    }
}
