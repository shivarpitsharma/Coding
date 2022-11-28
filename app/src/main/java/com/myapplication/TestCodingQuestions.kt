package com.myapplication

/**
 * Copyright (C) 2020 Loconav Inc.
 *
 * Created by Shivarpit Sharma
 * Date: 27.03.2022
 * Time: 10:35 am
 * Email: shivarpit.sharma@loconav.com
 *
 * Description:
 */
object TestCodingQuestions {

    fun solution(n: Int): Array<String> {
        val resultArray = returnParenthesisCombination(n)
        resultArray.sort()
        return resultArray
    }
    private fun returnParenthesisCombination(n: Int):Array<String>{
        val l: MutableList<String> = ArrayList()
        if (n == 1) {
            l.add("()")
            return l.toTypedArray()
        }
        for (st in returnParenthesisCombination(n - 1)) {
            l.add("$st()")
            l.add("($st)")
            if ("$st()" != "()$st") {
                l.add("()$st")
            }
        }
        return l.toTypedArray()
    }


    fun solution(t: Int, logs: Array<String>): String {
        val hashMap = hashMapOf<String,String>()
        for (logItem in logs){
            val listOfLogCases = logItem.split(" ")
            if(listOfLogCases[0].toInt() < t){
                hashMap[listOfLogCases[1]] = listOfLogCases[2]
            } else {
                hashMap.filter { it.value == "running"}.let {
                    return if(it.size > 1){
                        "-1"
                    }else{
                        it.keys.first()
                    }
                }
            }
        }
        return "-1"
    }


    fun solution(n: Array<String>): Array<String> {
        val list = mutableListOf<String>()
        val haspMap = object: LinkedHashMap<Int, Int>() {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
                return keys.contains(-999)
            }
        }
        first@ for (logItem in n){
            val logItemListAfterSplit = logItem.split(" ")
            when(logItemListAfterSplit[0]){
                "add" -> {
                    haspMap[logItemListAfterSplit[1].toInt()] = logItemListAfterSplit[2].toInt()
                }
                "get" -> {
                    list.add(
                        if (haspMap.containsKey(logItemListAfterSplit[1].toInt())) {
                            val a = haspMap[logItemListAfterSplit[1].toInt()]
                            a?.let {
                                haspMap[logItemListAfterSplit[1].toInt()] = it
                            }
                            haspMap[logItemListAfterSplit[1].toInt()].toString()
                        } else {
                            "-1"
                        }
                    )
                }

                "remove" -> {
                    if (haspMap.containsKey(logItemListAfterSplit[1].toInt())) {
                        list.add(haspMap[logItemListAfterSplit[1].toInt()].toString())
                        haspMap.remove(logItemListAfterSplit[1].toInt())
                    } else {
                        list.add("-1")
                    }
                }
                "evict" -> {
                    haspMap[-999]=0
                    haspMap.remove(-999)
                }
                "exit" -> {
                    break@first
                }
            }
        }
        return list.toTypedArray()
    }
}