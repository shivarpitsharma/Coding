package com.myapplication

import android.util.Log
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min


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

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     */

    fun containsDuplicate(nums: IntArray): Boolean {
        val numHashMap = HashMap<Int,Int>()
        nums.forEach {
           if(numHashMap.containsKey(it)) return true
            else numHashMap[it] = 1
        }
        return false
    }

    /**
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     */

    fun majorityElement(nums: IntArray): Int {
        val size = nums.size
        val numHashMap = HashMap<Int,Int>()
        nums.forEach { num ->
            if(numHashMap.containsKey(num)){
                numHashMap[num]?.plus(1)
                numHashMap[num]?.takeIf { it > size/2 }?.let {
                    return num
                }
            } else {
                numHashMap[num]?.plus(1)
            }
        }
        return -1
    }

    /**
     * Self dividing numbers :
     * number is divided by every digit it contains, 0 should not be one
     * Q : give all Self dividing numbers between range provided.
     */

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val returningList = mutableListOf<Int>()
        for (i in left..right) {
            val array = i.toString()
            var count = 0
            for (item in array.indices) {
                if (array[item].digitToInt() != 0) {
                    if(i % array[item].digitToInt() == 0){
                        count +=1
                    }
                }
            }
            if (count == array.length) {
                returningList.add(i)
            }
        }
        return returningList
    }

    // you can also use imports, for example:
// import kotlin.math.*

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

    fun solution(A: IntArray, B: IntArray, X: Int, Y: Int): Int {
        val maxHieght = 1919
        val maxWidth = 1079
        val minHieghtWidth = 0
        if (A.size > 100 || A.isEmpty()) return -1
        if (X !in 0..maxHieght || Y !in 0..maxWidth) return -1
        for (i in A.indices) {
            if (A[i] !in minHieghtWidth..maxHieght || B[i] !in minHieghtWidth..maxWidth) return -1
            if ((X - A[i]).times((X - A[i])) + (Y - B[i]).times((Y - B[i])) <= 400) {
                return i
            }
        }
        return -1
    }


    fun minCostToMoveChips(position: IntArray): Int {
        var oddcount = 0
        var evencount = 0
        val n = position.size
        for (i in position) {
            if (i % 2 == 0) ++evencount else ++oddcount
        }
        return if (evencount == n || oddcount == n) 0 else min(
            oddcount,
            evencount
        )
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hashMap = hashMapOf<Char,Int?>()
        for (i in magazine) {
            hashMap[i] = if (hashMap.containsKey(i)) {
                hashMap[i]?.plus(1)
            } else {
                1
            }
        }

        for(i in ransomNote) {
            if(hashMap.containsKey(i) && hashMap[i] == 0){
                return false
            } else if(hashMap.containsKey(i)){
                hashMap[i] = hashMap[i]?.minus(1)
            } else {
                return false
            }
        }
        return true
    }

    fun hasCycle(head: ListNode?): Boolean {
        return true
    }

    fun solution(inputString: String): String {
//        val hashMap = hashMapOf<Char?,Int?>()
        val stringBuilder = StringBuilder()
//        for(i in inputString){
//            if(hashMap.containsKey(i)){
//                hashMap[i]=hashMap[i]?.plus(1)
//            } else {
//                hashMap[i]= 1
//            }
//        }
//        hashMap.keys.forEach {
//            stringBuilder.append(hashMap[it]).append(it)
//        }
//        return stringBuilder.toString()

        val n: Int = inputString.length
            var i = 0
            while (i < n) {
                var count = 1
                while (i < n - 1 && inputString[i] == inputString[i + 1]) {
                    count++
                    i++
                }
                stringBuilder.append(count).append(inputString[i])
                i++
            }
        return stringBuilder.toString()
    }


    fun isPalindrome(head: ListNode?): Boolean {
        var pointer = head
        val stack = Stack<Int>()
        while(pointer?.next != null){
            if(stack.isEmpty() || pointer.`val` != stack.first()) {
                stack.push(pointer.`val`)
            } else {
                stack.pop()
            }
            pointer = pointer.next
        }
        if(pointer != null && stack.isEmpty()){
            return true
        }
        return false

    }

    fun maxProfit(prices: IntArray): Int {
        return 0
    }

}
class ListNode(var `val`: Int) {
   var next: ListNode? = null
}

