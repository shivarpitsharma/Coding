package com.myapplication

/**
 * Copyright (C) 2020 Loconav Inc.
 *
 * Created by Shivarpit Sharma
 * Date: 27.01.2022
 * Time: 8:46 am
 * Email: shivarpit.sharma@loconav.com
 */
object AlgorithmExpertEasyPart1 {
    /**
     * Q1 : Easy
     * Get two elements from array having sum equal to target sum
     * Submitted
     */

    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
        // Write your code here.
        val hashMap = HashMap<Int, Int>()
        array.forEach { item ->
            hashMap[item] = item
        }
        array.forEach { itemForSum ->
            val targetItem = targetSum - itemForSum
            if (hashMap.containsKey(targetItem) && itemForSum != targetItem) {
                return listOf(itemForSum, targetItem)
            }
        }
        return listOf<Int>()
    }

    /**
     * Q2
     * check if the sequence array is sub sequence in array
     * should be in order but possible it not sequenced.
     */
    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        var previousPosition = 0
        for (value in array) {
            if (previousPosition == sequence.size) break
            if (sequence[previousPosition] == value) previousPosition++
        }
        return previousPosition == sequence.size
    }

    /**
     * Q3
     * return new array of squares of integers of a given array
     */
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        // Write your code here.
        val list = ArrayList<Int>()
        array.forEachIndexed { index, i ->
            list.add(i*i)
        }
        list.sort()
        return list
    }
}