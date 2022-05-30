package com.jwzg.lib_common.utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.jwzg.lib_common.basecompoent.BaseApp

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      ToastUtils
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 18:59:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    toast的工具类
 */

fun toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(BaseApp.appContext, message, duration).show()
}


fun Context.toast(resId: Int) {
    val toast = Toast.makeText(this, resId, Toast.LENGTH_SHORT)
    toast.run {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}

fun Context.toast(text: CharSequence) {
    val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
    toast.run {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}

fun Context.longToast(resId: Int) {
    val toast = Toast.makeText(this, resId, Toast.LENGTH_LONG)
    toast.run {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}

fun Context.longToast(text: CharSequence) {
    val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
    toast.run {
        setGravity(Gravity.CENTER, 0, 0)
        show()
    }
}

fun View.toast(resId: Int) = context.toast(resId)

fun View.toast(text: CharSequence) = context.toast(text)

fun View.longToast(resId: Int) = context.longToast(resId)

fun View.longToast(text: CharSequence) = context.longToast(text)