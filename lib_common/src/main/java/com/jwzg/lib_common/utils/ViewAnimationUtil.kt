package com.jwzg.lib_common.utils

import android.view.View
import android.view.animation.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      ViewAnimationUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:55:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    常用动画的工具类
 */


private const val DEFAULT_DURATION: Int = 350

fun translate(view: View, startX: Int, startY: Int, endX: Int, endY: Int) {
    translate(view, startX, startY, endX, endY, DEFAULT_DURATION, LinearInterpolator())
}

fun translate(view: View, startX: Int, startY: Int, endX: Int, endY: Int, duration: Int) {
    translate(view, startX, startY, endX, endY, duration, LinearInterpolator())
}

fun translate(
    view: View,
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int,
    interpolator: Interpolator?
) {
    translate(view, startX, startY, endX, endY, DEFAULT_DURATION, interpolator)
}

fun translate(
    view: View,
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int,
    duration: Int,
    interpolator: Interpolator?
) {
    val animation = TranslateAnimation(
        startX.toFloat(),
        endX.toFloat(), startY.toFloat(), endY.toFloat()
    )
    animation.duration = duration.toLong()
    animation.fillAfter = true
    animation.interpolator = interpolator
    view.startAnimation(animation)
}

fun scale(view: View, fromX: Int, toX: Int, fromY: Int, toY: Int) {
    scale(view, fromX, toX, fromY, toY, DEFAULT_DURATION, LinearInterpolator())
}

fun scale(view: View, fromX: Int, toX: Int, fromY: Int, toY: Int, duration: Int) {
    scale(view, fromX, toX, fromY, toY, duration, LinearInterpolator())
}

fun scale(view: View, fromX: Int, toX: Int, fromY: Int, toY: Int, interpolator: Interpolator?) {
    scale(view, fromX, toX, fromY, toY, DEFAULT_DURATION, interpolator)
}

fun scale(
    view: View,
    fromX: Int,
    toX: Int,
    fromY: Int,
    toY: Int,
    duration: Int,
    interpolator: Interpolator?
) {
    val animation = ScaleAnimation(
        fromX.toFloat(), toX.toFloat(),
        fromY.toFloat(), toY.toFloat()
    )
    animation.duration = duration.toLong()
    animation.fillAfter = true
    animation.interpolator = interpolator
    view.startAnimation(animation)
}

fun alpha(view: View, fromAlpha: Float, toAlpha: Float) {
    alpha(view, fromAlpha, toAlpha, DEFAULT_DURATION, LinearInterpolator())
}

fun alpha(view: View, fromAlpha: Float, toAlpha: Float, duration: Int) {
    alpha(view, fromAlpha, toAlpha, duration, LinearInterpolator())
}

fun alpha(view: View, fromAlpha: Float, toAlpha: Float, interpolator: Interpolator?) {
    alpha(view, fromAlpha, toAlpha, DEFAULT_DURATION, interpolator)
}

fun alpha(
    view: View,
    fromAlpha: Float,
    toAlpha: Float,
    duration: Int,
    interpolator: Interpolator?
) {
    val animation = AlphaAnimation(fromAlpha, toAlpha)
    animation.duration = duration.toLong()
    animation.fillAfter = true
    animation.interpolator = interpolator
    view.startAnimation(animation)
}

fun rotate(view: View, fromDegree: Float, toDegree: Float) {
    rotate(view, fromDegree, toDegree, DEFAULT_DURATION, LinearInterpolator())
}

fun rotate(view: View, fromDegree: Float, toDegree: Float, duration: Int) {
    rotate(view, fromDegree, toDegree, duration, LinearInterpolator())
}

fun rotate(view: View, fromDegree: Float, toDegree: Float, interpolator: Interpolator?) {
    rotate(view, fromDegree, toDegree, DEFAULT_DURATION, interpolator)
}

fun rotate(
    view: View,
    fromDegree: Float,
    toDegree: Float,
    duration: Int,
    interpolator: Interpolator?
) {
    val animation = RotateAnimation(fromDegree, toDegree)
    animation.duration = duration.toLong()
    animation.fillAfter = true
    animation.interpolator = interpolator
    view.startAnimation(animation)
}

fun getFadeInAnimation(duration: Int): Animation {
    val animation = AlphaAnimation(0f, 1f)
    animation.duration = duration.toLong()
    animation.fillAfter = true
    return animation
}

fun getFadeOutAnimation(duration: Int): Animation {
    val animation = AlphaAnimation(1f, 0f)
    animation.duration = duration.toLong()
    animation.fillAfter = true
    return animation
}

fun slidingToBottomAnimation(duration: Int): Animation {
    val animation = TranslateAnimation(
        0f, 0f, 0f,
        getScreenHeight().toFloat()
    )
    animation.duration = duration.toLong()
    animation.fillAfter = true
    return animation
}