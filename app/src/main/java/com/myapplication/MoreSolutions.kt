package com.myapplication

import android.content.Context
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.regex.Pattern


/**
 * Created by Shivarpit
 */
data class checkedInandOut(
    var checkedIn: Boolean,
    var checkout: Boolean
)

object MoreSolutions {

    var list = listOf<checkedInandOut>(
        checkedInandOut(checkedIn = true, checkout = false),
        checkedInandOut(checkedIn = true, checkout = false)
    )

    fun printList(listdata : List<String>,country:String){
        println(country)
        listdata.forEachIndexed{index,string->
            println("$string is at $index index")
        }
    }

    fun operation(ope:String , a : Int , c :Int,d:Int, b : (x:Int,y:Int)->Int ) :Int{
        var res = b(a,b(c,d))
        println("doing $ope of $a $c and $d = ")
        return res
    }


    private fun addition(a : Int, b : (x:Int, y:Int)->Int ):Int {
        println("values got $a ${b.invoke(4,5)}")
        return a.plus(b.invoke(4,5))
    }

    fun add (){
        val add = operation("Adding",2,4,5,{x,y-> x+y })
        println(add)
        val mul = operation("Multiplying",2,4,5,{x,y-> x*y })
        println(mul)
        val sub = operation("Subtracting",2,4,5,{x,y-> x-y })
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

    fun isValidVehicleNumber(number: String): Boolean {
        return !number.isEmpty() && Pattern.matches("^[a-zA-Z0-9]?[a-zA-Z0-9]*", number)
    }

    fun checkForLetAndRun(): Boolean {
        val kotlin = 0

        kotlin?.takeIf { it == 0 }?.let { return true } ?: run { return false }
    }

    fun patternForWeb(context: Context) {
        val url =
            "https://www.loconav.com/web?url=https://www.loconav.com/privacypolicy&title=test custom locod&handler=chrome"
        val url1 =
            "https://www.loconav.com/web?url=https://www.loconav.com/privacypolicy&title=8439300002&handler=chrome"
        var appLinkUrl = url1
        if (!Patterns.WEB_URL.matcher(appLinkUrl).matches()) {
            Toast.makeText(context, "Invalid URL", Toast.LENGTH_SHORT).show()
            return
        } else {
            Toast.makeText(context, "valid URL", Toast.LENGTH_SHORT).show()

        }
    }

    fun emailPatternMatcher(string: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"

        val passwordRegex1 = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$"
        val passwordRegex2 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=]).{4,}$"
//        val passwordRegex = "(/^(?=.*\\d)(?=.*[A-Z])[0-9a-zA-Z]{4,}\$/)"

        val pat = Pattern.compile(passwordRegex1)
        return pat.matcher(string).matches()
    }

    fun checkResetPasswordValidity(
        currentPassword: String?,
        newPassword: String,
        confirmPassword: String
    ): Boolean {
        var isFieldsValid = true
        currentPassword?.let {
            isFieldsValid = when {
                currentPassword.isBlank() -> {
                    Log.i("isFieldsValid", "currentPassword isBlank")
                    false
                }
                currentPassword == newPassword -> {
                    Log.i("isFieldsValid", "currentPassword newPassword")
                    false
                }
                else -> {
                    abc(newPassword, confirmPassword)
                }

            }
        } ?: run {
            isFieldsValid = abc(newPassword, confirmPassword)
        }
        return isFieldsValid
    }


    fun abc(newPassword: String, confirmPassword: String): Boolean {
        var returningBoolean = true
        when {
            newPassword.isBlank() -> {
                Log.i("isFieldsValid", "newPassword isBlank")
                returningBoolean = false
            }
            confirmPassword.isBlank() -> {
                Log.i("isFieldsValid", "confirmPassword isBlank")
                returningBoolean = false
            }
            newPassword != confirmPassword -> {
                Log.i("isFieldsValid", "newPassword confirmPassword")
                returningBoolean = false
            }
            emailPatternMatcher(newPassword) -> {
                Log.i("isFieldsValid", "newPassword pattern")
                returningBoolean = false
            }
        }
        return returningBoolean
    }


    fun masknumber(number: String): String {
        return String.format(
            "%s%s%s",
            number.subSequence(0, 3),
            "X".repeat(number.length - 6),
            number.subSequence(number.length - 3, number.length)
        )
    }

    fun abc(a: Int, bo: Int) {
        val (data, dataValue) = if (a > 10) {
            Pair(a - 10, bo - 10)
        } else {
            Pair(a + 10, bo + 10)
        }
        Log.i("abctesting", data.toString())
        Log.i("abctesting", dataValue.toString())

    }

    fun changeStaticList(checked: Boolean) {
        list[0].checkedIn = checked
        list[0].checkout = true
        for (item in list) {
            Log.i("list", item.toString())
        }
    }

//    fun checkletandrunreturn(a:Long?,b:Double?):String?{
////        return b?.run {
////            a?.let {
////                "inside a let"
////            }?: null
////        }?:"inside b run"
////
////        b?.let {
////            a?.let {
////                return "inside a let"
////            }?: return null
////
////        }?: return "inside b run"
////
////        return if(b==null) "inside b run"
////        else {
////            if(a == null) null
////            else "inside a let"
////        }
//    }

    fun checkPhoneCode(phoneNumber: String, code: String): String {
        val phoneNumberExcluding = phoneNumber.subSequence(code.length, phoneNumber.length)
        if (phoneNumberExcluding.length % 2 == 0) {
            return phoneNumberExcluding.toString()
        } else {
            return "0$phoneNumberExcluding"
        }
    }


    fun new (){
        val a :Int=100
        val boxedA :Int? = a
        val anotherA:Int? = a

        val b :Int=10000
        val boxedB :Int? = b
        val anotherB:Int? = b
        Log.i("abctesting", "${boxedA === anotherA} ::::::: ${boxedB===anotherB}" )
    }

    fun coroutineChannels(){
        runBlocking {
            val table = Channel<Ball>() // a shared table
//            table.send(Ball(0)) // serve the ball
            launch { player("ping", table,300) }
            launch { player("pong", table,400) }
            table.send(Ball(0)) // serve the ball
            delay(1000)
            repeat(3){                //not working
                println(table.receive())     //not working
            }          //not working
            coroutineContext.cancelChildren() // game over, cancel them
        }
    }

    suspend fun player(name: String, table: Channel<Ball>,time: Long) {
        for (ball in table) { // receive the ball in a loop
            ball.hits++
            println("$name $ball")
            delay(time) // wait a bit
            table.send(ball) // send the ball back
        }
    }

    data class Ball(var hits: Int)


}

