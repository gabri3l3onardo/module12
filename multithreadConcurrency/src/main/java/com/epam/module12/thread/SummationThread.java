package com.epam.module12.thread;

import java.util.Iterator;
import java.util.Map;

public class SummationThread extends Thread {

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
