package com.myapplication

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.pow

/**
 * Created by Shivarpit
 */
object Solutions {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val arr_length = nums.size
        var num_result = arrayOf<Int>().toIntArray()
        for (i in 0 until arr_length) {
            for (j in i + 1 until arr_length) {
                if (nums[i] + nums[j] == target) {
                    num_result = intArrayOf(i, j)
                }
            }
        }
        return (num_result)
    }

    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var arrlength = nums.size
        var i = 0
        var j = 0

        while (j < arrlength) {
            if (nums[j] != `val`) {
                nums[i] = nums[j]
                i++
            }
            j++

        }
        return (i)
    }

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     */

    fun maxSubArray(nums: IntArray): Int {
        var arr_length = nums.size
        var sum_first = nums[0]
        var sum_temp = 0

        for (i in 0..arr_length - 1) {
            for (j in i..arr_length - 1) {
                sum_temp += nums[j]
                if (sum_temp > sum_first) {
                    sum_first = sum_temp
                }
            }
            sum_temp = 0
        }
        return (sum_first)
    }

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */

    fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        val arrayLength = nums.size
        for (i in 0 until arrayLength) {
            if (!map.containsKey(nums[i])) {
                map[nums[i]] = 1
            } else {
                var value = map[nums[i]]
                value = value?.plus(1)
                value?.let {
                    map[nums[i]] = value
                }
            }
        }
        for (item in map) {
            if (item.value == 1)
                return item.key
        }
        return 0
    }

    /**
     * Write an algorithm to determine if a number n is "happy".
     * A happy number is a number defined by the following process: Starting with any positive integer,
     * replace the number by the sum of the squares of its digits,
     * and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     * Return True if n is a happy number, and False if not.
     */

    fun isHappy(n: Int): Boolean {
        val uniqueNum = HashSet<Int>()
        var number = n

        while (uniqueNum.add(number)) {
            var value = 0
            while (number > 0) {
                value += (number.toDouble() % 10).pow(2.0).toInt()
                number /= 10
            }
            number = value
        }

        return number == 1
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * 1. You must do this in-place without making a copy of the array.
     * 2. Minimize the total number of operations.
     */

    fun moveZeroes(nums: IntArray): Unit {
        var count = 0
        for (i in nums.indices)
            if (nums[i] != 0)
                nums[count++] = nums[i]

        while (count < nums.size)
            nums[count++] = 0
        for (i in nums.indices) {
            print(nums[i])
        }
    }


    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     */

    fun reverseInteger(value: Int): Int {
        var result = 0L
        result = if (value > 0) {
            reversing(value.toLong())
        } else {
            reversing(value.times(-1).toLong()).times(-1)
        }
        return result.toInt()
    }

    private fun reversing(number: Long): Long {
        var numberToBeReversed = number
        var revNum = 0L
        while (numberToBeReversed > 0) {
            revNum = revNum * 10 + numberToBeReversed % 10
            numberToBeReversed /= 10
        }
        if ((number > 0 && revNum > Integer.MAX_VALUE)
            || (number < 0 && revNum < Integer.MIN_VALUE)
        ) {
            return 0
        }
        return revNum
    }

    /**
     * return true if the number is palindrome
     * eg : -121 -> false reason its reverse is 121-
     *      10 -> false reason its reverse is 01
     *      11 -> true reason its reverse in 11
     */

    fun isPalindrome(x: Int): Boolean {

        if (x < 0) {
            return false
        }
        // used reversing method made in previous question
        val result = reversing(x.toLong())
        return result.toInt() == x
    }

    /**
     * Convert roman Numerals to integer
     * Symbol       Value
     *  I             1
     *  V             5
     *  X             10
     *  L             50
     *  C             100
     *  D             500
     *  M             1000
     *  String will be provided of roman numerals
     *  convert it to respective Integer value
     */

    fun romanToInt(s: String): Int {

        fun getRomanValue(s: String): Int {
            return when (s) {
                "I" -> 1
                "V" -> 5
                "X" -> 10
                "L" -> 50
                "C" -> 100
                "D" -> 500
                "M" -> 1000
                else -> 0
            }
        }

        val romanArray = s.toCharArray()
        var result = 0
        for (i in romanArray.indices) {
            result += if (i < romanArray.size - 1
                && getRomanValue(romanArray[i].toString()) < getRomanValue(romanArray[i + 1].toString())
            ) {
                val sumValue = getRomanValue(romanArray[i].toString()).times(-1)
                sumValue
            } else {
                getRomanValue(romanArray[i].toString())
            }
        }
        return result
    }

    /**
     * Return the longest common prefix string from string array
     *
     * eg : result will be "fl" in ["flour","flower","floor"]
     *      result will be "" in ["dog","car","hen"]
     */

    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefixString = ""
        if (strs.size == 1) {
            commonPrefixString = strs[0]
        } else if (strs.size > 1) {
            var isfirsttwofailed = false
            for (i in strs.indices) {
                if (i < strs.size - 1) {
                    if (isfirsttwofailed && commonPrefixString.isEmpty()) {
                        return ""
                    } else {
                        if (isfirsttwofailed && commonPrefixString.isNotEmpty()) {
                            val thirdStringCharArray = strs[i + 1].toCharArray()
                            val commonPrefixArray = commonPrefixString.toCharArray()
                            val length = minOf(thirdStringCharArray.size, commonPrefixArray.size)
                            var k = 0
                            commonPrefixString = ""
                            while (k < length && commonPrefixArray[k] == thirdStringCharArray[k]) {
                                commonPrefixString += commonPrefixArray[k].toString()
                                k++
                            }
                        } else {
                            val firstStringCharArray = strs[i].toCharArray()
                            val secondStringCharArray = strs[i + 1].toCharArray()
                            val length =
                                minOf(firstStringCharArray.size, secondStringCharArray.size)
                            var j = 0
                            while (j < length && firstStringCharArray[j] == secondStringCharArray[j]) {
                                commonPrefixString += firstStringCharArray[j].toString()
                                j++
                            }
                            isfirsttwofailed = true
                        }
                    }

                }
            }
        }

        return commonPrefixString
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     *  1. Open brackets must be closed by the same type of brackets.
     *  2. Open brackets must be closed in the correct order.
     *
     *  Note that an empty string is also considered valid.
     *  eg: 1. Input: "()"
     *         Output: true
     *      2. Input: "()[]{}"
     *         Output: true
     *      3. Input: "(]"
     *         Output: false
     *      4. Input: "([)]"
     *         Output: false
     *      5. Input: "{[]}"
     *         Output: true
     */

    fun isValid(s: String): Boolean {
        val parenthesesStack: Stack<String> = Stack()
        val stringArray = s.toCharArray()
        for (i in stringArray.indices) {
            if (parenthesesStack.isEmpty()) {
                parenthesesStack.push(stringArray[i].toString())
            } else {
                if (stringArray[i].toString() == ")" || stringArray[i].toString() == "]" || stringArray[i].toString() == "}") {
                    if (isValidLeft(stringArray[i].toString(), parenthesesStack.peek())) {
                        parenthesesStack.pop()
                    } else {
                        parenthesesStack.push(stringArray[i].toString())
                    }
                } else {
                    parenthesesStack.push(stringArray[i].toString())
                }
            }
        }
        return parenthesesStack.isEmpty()
    }

    private fun isValidLeft(rightParen: String, topOfStack: String): Boolean {
        return when (rightParen) {
            ")" -> topOfStack == "("
            "]" -> topOfStack == "["
            "}" -> topOfStack == "{"
            else -> false
        }
    }

    /**
     * Merge two sorted linked lists and return it as a new sorted list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * eg : Input: 1->2->4, 1->3->4
     *      Output: 1->1->2->3->4->4
     */

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun getList1NodeOne(): ListNode? {
        val list1Node1 = ListNode(1)
        val list1Node2 = ListNode(2)
        val list1Node3 = ListNode(4)
        list1Node1.next = list1Node2
        list1Node2.next = list1Node3
        return list1Node1
    }

    fun getList2NodeOne(): ListNode? {
        val list2Node1 = ListNode(1)
        val list2Node2 = ListNode(3)
        val list2Node3 = ListNode(4)
        list2Node1.next = list2Node2
        list2Node2.next = list2Node3
        return list2Node1
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var listOneNode = l1
        var listTwoNode = l2
        val l3 = ListNode(0)
        var ptr = l3

        while (true) {
            if (listOneNode == null && listTwoNode == null) {
                break
            } else if (listOneNode == null) {
                ptr.next = listTwoNode
                break
            } else if (listTwoNode == null) {
                ptr.next = listOneNode
                break
            } else {
                var smallerValue = 0
                if (listOneNode.`val` < listTwoNode.`val`) {
                    smallerValue = listOneNode.`val`
                    listOneNode = listOneNode.next
                } else {
                    smallerValue = listTwoNode.`val`
                    listTwoNode = listTwoNode.next
                }

                val newNode = ListNode(smallerValue)
                ptr.next = newNode
                ptr = ptr.next!!
            }
        }
        return l3.next
    }

    /**
     * Given a sorted array nums,
     * remove the duplicates in-place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array,
     * you must do this by modifying the input array in-place
     * with O(1) extra memory.
     *
     * eg :
     *      Given nums = [1,1,2],
     *      Your function should return length = 2,
     *      with the first two elements of nums being 1 and 2 respectively.
     *      It doesn't matter what you leave beyond the returned length.
     */

    fun getIntArray(): IntArray {
        val intArray = IntArray(5)
        intArray[0] = 1
        intArray[1] = 1
        intArray[2] = 1
        intArray[3] = 2
        intArray[4] = 3
        return intArray
    }

    fun removeDuplicates(nums: IntArray): IntArray {
        var count = 1
        for (i in nums.indices) {
            if (i < nums.size - 1 && nums[i] != nums[i + 1]) {
                nums[count++] = nums[i + 1]
            }
        }
        return nums
    }

    /**
     * Given a sorted array and a target value,
     * return the index if the target is found.
     * If not, return the index where
     * it would be if it were inserted in order.
     */

    fun searchInsert(target: Int): Int {
        val intArray = IntArray(4)
        intArray[0] = 1
        intArray[1] = 3
        intArray[2] = 5
        intArray[3] = 6
        for (i in intArray.indices) {
            when {
                intArray[i] == target -> return i
                i < intArray.size - 1 && intArray[i] < target && intArray[i + 1] > target || i == intArray.size - 1 && intArray[i] < target -> return i + 1
                i == 0 && intArray[i] > target -> return 0
            }
        }
        return 0
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
     */

    fun lengthOfLastWord(s: String): Int {
        return 0
    }

    /**
     * Array of 1-10 ,
     * print fizzbuzz if array element is divisible by both 3 and 5
     * print fizz if array element is divisible by 3
     * print buzz if array element is divisible by 5
     * print number if it is neither divisible by 5 nor 3
     */

    fun printAccordingToDivisibility(): String {
        val array = IntArray(10)
        array[0] = 1
        array[1] = 2
        array[2] = 3
        array[3] = 4
        array[4] = 5
        array[5] = 6
        array[6] = 7
        array[7] = 8
        array[8] = 9
        array[9] = 10

        for (i in array) {
            return when {
                i % 3 == 0 && i % 5 == 0 -> "fizzbuzz"
                i % 3 == 0 -> "fizz"
                i % 5 == 0 -> "buzz"
                else -> i.toString()
            }
        }
        return ""
    }

    /**
     * Given two arrays,
     * write a function to compute their intersection.
     *
     * eg: Input: nums1 = [1,2,2,1], nums2 = [2,2]
     *     Output: [2]
     *
     *     Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     *     Output: [9,4]
     */

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        return if (nums1.size > nums2.size) {
            returnIntersection(nums1, nums2)
        } else {
            returnIntersection(nums2, nums1)
        }
    }

    private fun returnIntersection(largerArray: IntArray, smallerArray: IntArray): IntArray {
        val hashmap = HashMap<Int, Boolean>()
        val returningArray = ArrayList<Int>()
        for (item in largerArray) {
            if (!hashmap.containsKey(item)) {
                hashmap[item] = true
            }
        }

        for (item in smallerArray) {
            if (hashmap.containsKey(item) && !returningArray.contains(item)) {
                returningArray.add(item)
            }
        }

        return returningArray.toIntArray()
    }

    /**
     * Pattern matcher for special character
     */

    fun isValidName(): Boolean {
        val string = "UP14BD7717"
        return Pattern.matches("^[a-zA-Z0-9]?[a-zA-Z0-9]*", string)
    }

}