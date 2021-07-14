package com.epam.module12;

import com.epam.module12.thread.AdditionThread;
import com.epam.module12.thread.SummationThread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task1ConcurrentHashMap {

    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = new ConcurrentHashMap<>();

        Thread tAdd = new AdditionThread(hashMap);
        Thread tSum = new SummationThread(hashMap);
        tAdd.start();
        tSum.start();
    }


}
