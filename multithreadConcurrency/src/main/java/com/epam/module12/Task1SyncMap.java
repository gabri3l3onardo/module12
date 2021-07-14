package com.epam.module12;

import com.epam.module12.thread.AdditionSyncThread;
import com.epam.module12.thread.SummationSyncThread;

import java.util.*;

public class Task1SyncMap {

    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());

        Thread tAdd = new AdditionSyncThread(hashMap);
        Thread tSum = new SummationSyncThread(hashMap);
        tAdd.start();
        tSum.start();
    }


}
