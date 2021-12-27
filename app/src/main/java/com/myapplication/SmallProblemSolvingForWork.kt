package com.myapplication

import android.util.Log
import android.util.Patterns
import java.util.regex.Pattern

/**
 * Copyright (C) 2020 Loconav Inc.
 *
 * Created by Shivarpit Sharma
 * Date: 27.12.2021
 * Time: 10:16 am
 * Email: shivarpit.sharma@loconav.com
 *
 * Description:
 * Class has utility methods to test out small logics related to work
 */
object SmallProblemSolvingForWork {

    /**
     * method to exclude code from phone number and returns even digit phone number
     * @param phoneNumber phone number string including number and code
     * @param code code String to be excluded from phone number
     * @return phone number excluding code and if not even digits then prepending 0
     */
    fun checkPhoneCode(phoneNumber: String, code: String): String {
        val phoneNumberExcluding = phoneNumber.subSequence(code.length, phoneNumber.length)
        return if (phoneNumberExcluding.length % 2 == 0) {
            phoneNumberExcluding.toString()
        } else {
            "0$phoneNumberExcluding"
        }
    }

    /**
     * Pattern matcher for indian vehicle number
     * @param number Vehicle number string
     * @return boolean if [number] can be a vehicle number
     */
    fun isValidVehicleNumber(number: String): Boolean {
        return !number.isEmpty() && Pattern.matches("^[a-zA-Z0-9]?[a-zA-Z0-9]*", number)
    }

    /**
     * method to check the url matches [Patterns.WEB_URL]
     */
    fun patternForWebURL() {
        val urlTestCase1 =
            "https://www.loconav.com/web?url=https://www.loconav.com/privacypolicy&title=test custom locod&handler=chrome"
        val urlTestCase2 =
            "https://www.loconav.com/web?url=https://www.loconav.com/privacypolicy&title=8439300002&handler=chrome"
        var appLinkUrl = urlTestCase2
        if (!Patterns.WEB_URL.matcher(appLinkUrl).matches()) {
            Log.d("Web url pattern matcher", "Invalid URL")
            return
        } else {
            Log.d("Web url pattern matcher", "Valid URL")
        }
    }

    /**
     * Method for masking few middle digits of a phone number with "X"
     * @param number : phone Number for masking
     * @return masked number
     */
    fun maskNumber(number: String): String {
        return String.format(
            "%s%s%s",
            number.subSequence(0, 3),
            "X".repeat(number.length - 6),
            number.subSequence(number.length - 3, number.length)
        )
    }

    /**
     * method to extract file name from a server s3 url
     * @param url : server s3 URL string
     * @return File name string
     */
    fun getFileName(url: String): String {
        val s = url.split("?")[0]
        val sa = s.subSequence(url.lastIndexOf("original/"), s.length)
        val sb = sa.split("/")[1]
        return sb
    }
}