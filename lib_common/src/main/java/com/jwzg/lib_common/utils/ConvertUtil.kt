package com.jwzg.lib_common.utils

import android.text.TextUtils

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      ConvertUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:41:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    字符串的转换操作
 */


private const val FLOATING_SEPARATOR: String = "."

/**
 * 字符串转整型
 * @param value
 * @return
 */
fun stringToInt(value: String): Int {
    if (!TextUtils.isEmpty(value)) {
        try {
            return if (value.contains(FLOATING_SEPARATOR)) {
                value.toDouble().toInt()
            } else {
                value.toInt()
            }
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
    }
    return 0
}

fun stringToInt(value: String, defaultValue: Int): Int {
    if (!TextUtils.isEmpty(value)) {
        try {
            return if (value.contains(FLOATING_SEPARATOR)) {
                value.toDouble().toInt()
            } else {
                value.toInt()
            }
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
    }
    return defaultValue
}


/**
 * 字符串转长整型
 * @param value
 * @return
 */
fun stringToLong(value: String): Long {
    if (!TextUtils.isEmpty(value)) {
        try {
            return value.toLong()
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
    }
    return 0L
}

/**
 * 字符串转单精度
 * @param value
 * @return
 */
fun stringToFloat(value: String): Float {
    if (!TextUtils.isEmpty(value)) {
        try {
            return value.toFloat()
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
    }
    return 0f
}

/**
 * 字符串转双精度
 * @param value
 * @return
 */
fun stringToDouble(value: String): Double {
    if (!TextUtils.isEmpty(value)) {
        try {
            return value.toDouble()
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
    }
    return 0.0
}

/**
 * 字符串转布尔类型
 * @param value
 * @return
 */
fun stringToBoolean(value: String): Boolean {
    return "1" == value || java.lang.Boolean.parseBoolean(value)
}