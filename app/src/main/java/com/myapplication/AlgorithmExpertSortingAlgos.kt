package com.myapplication

/**
 * Copyright (C) 2020 Loconav Inc.
 *
 * Created by Shivarpit Sharma
 * Date: 18.03.2022
 * Time: 1:57 pm
 * Email: shivarpit.sharma@loconav.com
 *
 * Description:
 */
object AlgorithmExpertSortingAlgos {

    /**
     * Q7 [AlgorithmExpertEasyPart1]. Selection sort
     * O(n2)
     * for every iteration check for index of smallest element from remaining list and swap.
     */
    fun selectionSort(array: MutableList<Int>): List<Int> {
        for (i in 0 until array.size) {
            var min = i
            for (j in i + 1 until array.size) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            val c = array[i]
            array[i] = array[min]
            array[min] = c

        }
        return array
    }

    /**
     * Q8 [AlgorithmExpertEasyPart1] Bubble sort
     * O(n2)
     * Swap every element from 0 to n if to send largest to the end of array
     */
    fun bubbleSort(array: MutableList<Int>): List<Int> {
        for (i in 0 until array.size) {
            for (j in 0 until array.size - 1) {
                if (array[j] > array[j + 1]) {
                    val a = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = a
                }
            }
        }
        return array
    }

    /**
     * Q9 [AlgorithmExpertEasyPart1] Insertion sort
     * Take element and check in the list before it and goes with swapping till there is any number smaller that current.
     * O(n2)
     */
    fun insertionSort(array: MutableList<Int>): List<Int> {
        for (i in 1 until array.size) {
            for (j in i downTo 0) {
                if (array[j] > array[j - 1]) {
                    val a = array[j]
                    array[j] = array[j - 1]
                    array[j - 1] = a
                }
            }
        }
        return array
    }

}