package com.myapplication

import android.util.Log


/**
 * Created by Shivarpit
 */

object SolutionsPartTwoKotlin {

    /**
     * private method for [performAllArithmaticOperations]
     */
    private fun operation(ope: String, a: Int, c: Int, d: Int, b: (x: Int, y: Int) -> Int): Int {
        val res = b(a, b(c, d))
        println("doing $ope of $a $c and $d = ")
        return res
    }

    /**
     * Method to perform all arithmatic operations using lamda and overriding behaviour for each operation
     */
    fun performAllArithmaticOperations() {
        val add = operation("Adding", 2, 4, 5, { x, y -> x + y })
        println(add)
        val mul = operation("Multiplying", 2, 4, 5, { x, y -> x * y })
        println(mul)
        val sub = operation("Subtracting", 2, 4, 5, { x, y -> x - y })
        println(sub)
    }

    /**
     * Find equilibrium index of array
     * i.e : sum of elements on left of that index is equal to
     * sum of element on right of that index.
     * in O(n)
     */
    fun findEquiInOofN(): Int {
        val array = arrayOf(-4, 1, 5, 2, -4, 3, 0)
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

    /**
     * get maximum sum of pairs of elements in the array having the same digit sum
     */

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

    /**
     *
     * Find needle in a haystack
     * ie: Return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */

    fun findNeedleInHaystack(needle: String, hayStack: String): Int {
        val j = 0
        if (needle.isBlank()) {
            return 0
        }
        if (needle.length > hayStack.length) {
            return -1
        }
        for (i in hayStack.indices) {
            val hayStackChar = hayStack.toCharArray()[i]
            val needleChar = needle.toCharArray()[j]

            if (hayStackChar == needleChar) {
                val subString = hayStack.subSequence(i, i + needle.length)
                if (subString == needle) {
                    return i
                }
            }
        }
        return -1
    }

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word (last word means the last appearing word if we loop from left to right)
     * in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a maximal substring consisting of non-space characters only.
     *
     * eg : Input: "Hello World"
     *      Output: 5
     *
     *      Input: "a "
     *      Output: 1
     *
     *      Input: "  day "
     *      Output: 3
     */

    fun lengthOfLastWord(s: String): Int {
        var len = 0
        var found = false
        var i: Int = s.length - 1
        while (!found && i >= 0) {
            if (s.toCharArray()[i] != ' ') {
                len++
            } else if (len != 0) {
                found = true
            }
            i--
        }

        return len
    }


    /**
     * Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list,
     * and each element in the array contains a single digit.
     * You may assume the integer does not contain any leading zero,
     * except the number 0 itself.
     *
     *  eg : Input: digits = [1,2,3]
     *  Output: [1,2,4]
     *  Explanation: The array represents the integer 123.
     *
     *  Input: digits = [4,3,2,1]
     *  Output: [4,3,2,2]
     *  Explanation: The array represents the integer 4321.
     *
     *  Input: digits = [0]
     *  Output: [1]
     */

    fun plusOne(digits: IntArray): IntArray {
        digits[digits.size - 1] += 1
        return if (digits[digits.size - 1] > 9) {
            var count = 1
            for (i in digits.size - 1 downTo 0) {
                if (count == 0) {
                    break
                }
                if (digits[i] + count > 9) {
                    digits[i] = 0
                    count = 1
                } else {
                    digits[i] += count
                    count = 0
                }
            }
            if (count == 0) {
                digits
            } else {
                val arrayOut = IntArray(digits.size + 1)
                for (i in arrayOut.indices) {
                    if (i == 0) {
                        arrayOut[i] = 1
                    } else {
                        arrayOut[i] = 0
                    }
                }
                arrayOut
            }

        } else {
            digits
        }
    }

    /**
     * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
     * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59.
     * The earliest 24-hour time is 00:00, and the latest is 23:59.
     * Return the latest 24-hour time in "HH:MM" format.
     * If no valid time can be made, return an empty string
     */

    fun getMaxTimeFromArray() {
        val array = arrayOf(1, 2, 3, 4)
    }

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *  eg: Input: s = "abcabcbb"
     *  Output: 3
     *  Explanation: The answer is "abc", with the length of 3.
     *
     *  Input: s = "bbbbb"
     *  Output: 1
     *  Explanation: The answer is "b", with the length of 1.
     */

    fun lengthOfLongestSubstring(s: String): Int {
        var maxCount = 0
        s.forEach {

        }
        return 0
    }
}

