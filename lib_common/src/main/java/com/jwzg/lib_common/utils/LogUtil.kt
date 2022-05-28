package com.jwzg.lib_common.utils

import android.util.Log
import com.jwzg.lib_common.BuildConfig

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      LogUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:50:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    打印的工作类
 */


val TAG: String = "DEFAULT"

/**
 * 是否需要开启Log
 */
private val NEED_LOG: Boolean = BuildConfig.DEBUG

fun i(content: String) {
    if (NEED_LOG) {
        Log.i(TAG, getLogPrefix() + content)
    }
}

fun i(tag: String?, content: String) {
    if (NEED_LOG) {
        Log.i(tag, getLogPrefix() + content)
    }
}

fun d(content: String) {
    if (NEED_LOG) {
        Log.d(TAG, getLogPrefix() + content)
    }
}

fun d(tag: String?, content: String) {
    if (NEED_LOG) {
        Log.d(tag, getLogPrefix() + content)
    }
}

fun e(content: String) {
    if (NEED_LOG) {
        Log.e(TAG, getLogPrefix() + content)
    }
}

fun e(tag: String?, content: String) {
    if (NEED_LOG) {
        Log.e(tag, getLogPrefix() + content)
    }
}

fun v(content: String) {
    if (NEED_LOG) {
        Log.v(TAG, getLogPrefix() + content)
    }
}

fun v(tag: String?, content: String) {
    if (NEED_LOG) {
        Log.v(tag, getLogPrefix() + content)
    }
}

fun w(content: String) {
    if (NEED_LOG) {
        Log.w(TAG, getLogPrefix() + content)
    }
}

fun w(tag: String?, content: String) {
    if (NEED_LOG) {
        Log.w(tag, getLogPrefix() + content)
    }
}

private fun getLogPrefix(): String {
    return getClassName() + "(" + getLineNumber() + ")" + "$" + getMethodName() + ": "
}

/**
 * 获取Log所在的类名 （getStackTrace的索引根据调用的顺序来决定，可通过打印Log栈来获取）
 * @return
 */
private fun getClassName(): String? {
    try {
        val classPath = Thread.currentThread().stackTrace[5].className
        return classPath.substring(classPath.lastIndexOf(".") + 1)
    } catch (e: Exception) {
        e.printStackTrace(System.out)
    }
    return null
}

/**
 * 获取Log所在的方法名
 * @return
 */
private fun getMethodName(): String? {
    try {
        return Thread.currentThread().stackTrace[5].methodName
    } catch (e: Exception) {
        e.printStackTrace(System.out)
    }
    return null
}

/**
 * 获取Log所在的行
 * @return
 */
private fun getLineNumber(): Int {
    try {
        return Thread.currentThread().stackTrace[5].lineNumber
    } catch (e: Exception) {
        e.printStackTrace(System.out)
    }
    return 0
}