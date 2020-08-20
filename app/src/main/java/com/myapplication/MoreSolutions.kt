package com.myapplication

import android.util.Log

/**
 * Created by Shivarpit
 */
object MoreSolutions {

    /**
     * Find equilibrium index of array
     * i.e : sum of elements on left of that index is equal to
     * sum of element on right of that index.
     * in O(n)
     */
    fun findEquiInOofN(): Int {
        val array = arrayOf(-8, 3, 4, -9, 2, -5)
        var sum = 0
        var sumFromLeft = 0
        for (i in array.indices) {
            sum += array[i]
        }

        for (i in array.indices) {
            sum -= array[i]

            if (sumFromLeft == sum) {
                return i
            }
            sumFromLeft += array[i]
        }
        return -1
    }

    /**
     * Find equilibrium index of array
     * i.e : sum of elements on left of that index is equal to
     * sum of element on right of that index.
     * in O(n)
     */

    fun findEquiBadApproach() {
        val array = arrayOf(-8, 3, 4, -9, 2, -5)
        val length = array.size
        val pivot = length / 2
        Log.i("result", findNewEquiRecursive(array, pivot).toString())
    }

    private fun findNewEquiRecursive(array: Array<Int>, pivot: Int): Int {
        var sum1 = 0
        var sum2 = 0
        for (i in 0 until pivot) {
            sum1 += array[i]
        }

        for (j in array.size - 1 until pivot) {
            sum2 += array[j]
        }

        when {
            sum1 > sum2 -> {
                findNewEquiRecursive(array, pivot - 1)
            }
            sum1 < sum2 -> {
                findNewEquiRecursive(array, pivot + 1)
            }
            else -> {
                return pivot
            }
        }
        return -8
    }


    fun getMaxSum() {
        val array = arrayOf(55, 23, 32, 46, 88)
        val hashmap = hashMapOf<Int, Int>()
        var max = 0
        for (i in array.indices) {
            var n = array[i]
            var sum = 0
            while (n > 0) {
                sum += n % 10
                n /= 10
            }
            if (hashmap.containsKey(sum) && hashmap[sum] != null) {
                val localMx = hashmap[sum]!!.plus(array[i])
                if (localMx > max) {
                    max = localMx
                }
            } else {
                hashmap[sum] = array[i]
            }
        }

        Log.i("result", max.toString())
    }


}