package com.jwzg.lib_common.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Rect

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      DisplayUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:43:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    获得屏幕信息
 */

/**
 * 获取屏幕宽度
 * @return
 */
fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

/**
 * 获取屏幕高度
 * @return
 */
fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}

/**
 * 获取屏幕物理像素密度
 * @return
 */
fun getScreenDensity(): Float {
    return Resources.getSystem().displayMetrics.density
}

/**
 * dp转px
 * @param dp
 * @return
 */
fun dpToPx(dp: Int): Int {
    return Math.round(Resources.getSystem().displayMetrics.density * dp + 0.5f)
}

/**
 * sp转px
 * @param sp
 * @return
 */
fun spToPx(sp: Int): Int {
    return Math.round(Resources.getSystem().displayMetrics.scaledDensity * sp + 0.5f)
}

/**
 * px转dp
 * @param px
 * @return
 */
fun pxToDp(px: Int): Int {
    return Math.round(px / Resources.getSystem().displayMetrics.density + 0.5f)
}

/**
 * px转sp
 * @param px
 * @return
 */
fun pxToSp(px: Int): Int {
    return Math.round(px / Resources.getSystem().displayMetrics.scaledDensity + 0.5f)
}

/**
 * 获取状态栏的高度
 * @param context
 * @return
 */
fun getStatusHeight(context: Context): Int {
    val rect = Rect()
    (context as Activity).window.decorView.getWindowVisibleDisplayFrame(rect)
    return rect.top
}

/**
 * 获取屏幕参数
 * @return
 */
fun getScreenParams(): String? {
    return getScreenWidth().toString() + "*" + getScreenHeight()
}