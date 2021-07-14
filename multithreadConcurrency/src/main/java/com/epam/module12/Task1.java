package com.epam.module12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        Thread tAdd = new AdditionThread(hashMap);
        Thread tSum = new SummationThread(hashMap);
        tAdd.start();
        tSum.start();
    }


}

class SummationThread extends Thread {

    private Map<Integer, Integer> hashMap;

    public SummationThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void run() {
        int result = 0;
        Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator();
        while(it.hasNext()) {
            try {
                Thread.sleep(1000);
                Map.Entry<Integer, Integer> entry = it.next();
                result += entry.getValue();
                System.out.println("Sum "+entry.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total: "+result);
    }

}

class AdditionThread extends Thread {

    private Map<Integer, Integer> hashMap;
    private Integer[] arrInts = new Integer[]{1,2,3,4,5,6,7,8,9,10};

    public AdditionThread(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void run() {
        for(int val : arrInts) {
            hashMap.put(val, val);
            System.out.println("Added "+val);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}