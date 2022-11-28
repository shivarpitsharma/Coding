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


    /**
     * Q4
     * return index of first non repeating character in string
     */

    fun firstNonRepeatingCharacter(string: String): Int {
        //using hashmap can be a better approach
        for (i in string.indices) {
            if (!string.removeRange(IntRange(i, i)).contains(string[i])) {
                return i
            }
        }
        return -1
    }

    /**
     * Q5
     * return true if you are able to generate document = "aabbcc" from characters "abcabc"
     * generation logic : frequency of unique characters should be same include spaces
     */

    fun generateDocument(characters: String, document: String): Boolean {
        val characters = "Bste!hetsi ogEAxpelrt x "
        val document = "AlgoExpert is the Best!"
        val hashMap = HashMap<Char, Int>()
        for (char in characters.toCharArray()) {
            if (hashMap.containsKey(char)) {
                val value = hashMap[char] ?: 0
                hashMap[char] = value.plus(1)
            } else {
                hashMap[char] = 1
            }
        }

        for (char in document.toCharArray()) {
            if (!hashMap.containsKey(char) || hashMap[char] == 0 || hashMap[char] == -1) {
                return false
            } else {
                val value = hashMap[char] ?: 0
                hashMap[char] = value.minus(1)
            }
        }
        return true
    }

    /**
     * Q6
     * Is Palindrome
     */

    fun isPalindrome(string: String): Boolean {
        var j = string.length
        for (i in 0..string.length.div(2)) {
            j -= 1
            if(string[i] != string[j]){
                return false
            }
        }
        return true
    }

    /**
     * Q10
     * Length encoding
     * "AAAAAAAAAAAAAA" can be 14A but it will be 9A5A(only below 10 should be considered)
     * "AABBCCCD" -> 2A2B3C1D
     */
    fun runLengthEncoding(string: String): String {
        var currentRunChar = string[0]
        var currentLength = 1
        val charArray = mutableListOf<String>()
        for (i in 1 until string.length) {
            if(string[i] == string[i-1]){
                currentLength +=1
            }else{
                if(currentLength>9){
                    val count = currentLength/9
                    for(k in 0 until count){
                        charArray.add(9.toString())
                        charArray.add(string[i-1].toString())
                    }
                    charArray.add((currentLength%9).toString())
                    charArray.add(string[i-1].toString())
                }else{
                    charArray.add(currentLength.toString())
                    charArray.add(string[i-1].toString())
                }
                currentLength = 1
                currentRunChar = string[i]
            }
        }
        val stringBuilder=StringBuilder()
        charArray.forEach {
            stringBuilder.append(it)
        }
        stringBuilder.append(currentLength)
        stringBuilder.append(currentRunChar)
        return stringBuilder.toString()
    }


    fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
        var maxPoints = 0
        val hashMap = hashMapOf<String, Int>()
        var winnerYet = ""
        competitions.forEachIndexed { index, list ->
            val winnerPosition = kotlin.math.abs(results[index] - 1)
            hashMap[list[winnerPosition]] = hashMap[list[winnerPosition]]?.plus(3) ?: 3
            maxPoints = if ((hashMap[list[winnerPosition]] ?: maxPoints) > maxPoints) {
                winnerYet = list[winnerPosition]
                hashMap[list[winnerPosition]] ?: maxPoints
            } else {
                maxPoints
            }

        }
        return winnerYet
    }




}
