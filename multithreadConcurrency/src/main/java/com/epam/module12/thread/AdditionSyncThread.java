package com.epam.module12.thread;

import java.util.Map;

public class AdditionSyncThread extends Thread {

    private Map<Integer, Integer> hashMap;
    private Integer[] arrInts = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public AdditionSyncThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void run() {
        synchronized (hashMap) {
            for (int val : arrInts) {
                hashMap.put(val, val);
                System.out.println("Added " + val);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}