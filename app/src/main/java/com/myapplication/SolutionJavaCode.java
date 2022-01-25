package com.myapplication;


import android.util.Log;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class SolutionJavaCode {

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

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     */

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int num : nums){
            if(hashmap.containsKey(num)){
                return true;
            }else {
                hashmap.put(num,1);
            }
        }
        return false;
    }
}






