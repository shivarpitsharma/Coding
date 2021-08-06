package com.myapplication;


import android.util.Log;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

class solutionJava {

    public void callingJava() {
        Integer[] array = {1, 2, 3, 4, 5};
        printarray(array);
        doublearray(array);
        printarray(array);
    }

    private void printarray(@NotNull Integer[] array) {
        for (Integer integer : array) {
            Log.i("array", integer.toString());
        }
    }

    private void doublearray(@NotNull Integer[] array) {
//        array = new Integer[] {1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
    }

    public void exceptionThreading() {
        try {
            Log.i("exception", "thread name " + Thread.currentThread().getName());
            ExceptionThread a = new ExceptionThread("background");
            a.start();
        } catch (Exception e) {
            Log.i("exception", "exception" + e.toString());
        }
    }

    public static void hello(){
        MyThread m = new MyThread();
            m.start();
    }
}

class ExceptionThread extends Thread {
    ExceptionThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Log.i("exception", "thread new name " + Thread.currentThread().getName());
        throw new NullPointerException();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}



class MyThread extends Thread {

    @Override
    public void run() {
//        throw new Exception();
        System.out.println("inside run");
    }
}





