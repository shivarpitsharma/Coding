package com.myapplication;


import android.util.Log;

import org.jetbrains.annotations.NotNull;

class solutionJava {

    public void callByValueOrRef(){
        Integer[] array = {1,2,3,4,5};
        printarray(array);
        doublearray(array);
        printarray(array);
    }

    private void printarray(@NotNull Integer[] array){
        for (Integer integer : array) {
            Log.i("array", integer.toString());
        }
    }
    private void doublearray(@NotNull Integer[] array){
        for(int i=0;i<array.length;i++){
            array[i]=array[i]*2;
        }
    }
}

