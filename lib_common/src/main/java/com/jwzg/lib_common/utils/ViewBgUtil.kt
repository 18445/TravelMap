package com.jwzg.lib_common.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      ViewBgUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 18:36:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    设置View的背景
 */
/**
 * 设置状态式背景时需要的最小资源数量
 */
const val MIN_RESOURCE_COUNT = 2

/**
 * 圆角相同的纯色背景
 * @param view
 * @param bgColor
 * @param radius
 */
fun setShapeBg(view: View, bgColor: Int, radius: Int) {
    ViewCompat.setBackground(view, getDrawable(GradientDrawable.RECTANGLE, bgColor, radius))
}

fun setShapeBg(view: View, bgColor: Int, borderColor: Int, borderWidth: Int, radius: Int) {
    ViewCompat.setBackground(
        view,
        getDrawable(GradientDrawable.RECTANGLE, bgColor, borderColor, borderWidth, radius)
    )
}

fun setShapeBg(view: View, shape: Int, bgColor: Int, radius: Int) {
    ViewCompat.setBackground(view, getDrawable(shape, bgColor, radius))
}

fun setShapeBg(
    view: View, shape: Int, bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(view, getDrawable(shape, bgColor, borderColor, borderWidth, radius))
}

/**
 * 圆角不同的纯色背景
 * @param view
 * @param bgColor
 * @param radius
 */
fun setShapeBg(view: View, bgColor: Int, radius: FloatArray?) {
    ViewCompat.setBackground(view, getDrawable(GradientDrawable.RECTANGLE, bgColor, radius))
}

fun setShapeBg(
    view: View, bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view,
        getDrawable(GradientDrawable.RECTANGLE, bgColor, borderColor, borderWidth, radius)
    )
}

fun setShapeBg(view: View, shape: Int, bgColor: Int, radius: FloatArray?) {
    ViewCompat.setBackground(view, getDrawable(shape, bgColor, radius))
}

fun setShapeBg(
    view: View, shape: Int, bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(view, getDrawable(shape, bgColor, borderColor, borderWidth, radius))
}

/**
 * 圆角相同的渐变背景
 * @param view
 * @param orientation
 * @param bgColor
 * @param radius
 */
fun setShapeBg(
    view: View, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, radius: Int
) {
    ViewCompat.setBackground(
        view, getDrawable(
            GradientDrawable.RECTANGLE, orientation, bgColor,
            0, 0, radius
        )
    )
}

fun setShapeBg(
    view: View, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view, getDrawable(
            GradientDrawable.RECTANGLE, orientation, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setShapeBg(
    view: View, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, radius: Int
) {
    ViewCompat.setBackground(view, getDrawable(shape, orientation, bgColor, 0, 0, radius))
}

fun setShapeBg(
    view: View, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view,
        getDrawable(shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 圆角不同的渐变背景
 * @param view
 * @param orientation
 * @param bgColor
 * @param radius
 */
fun setShapeBg(
    view: View, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view, getDrawable(
            GradientDrawable.RECTANGLE, orientation, bgColor,
            0, 0, radius
        )
    )
}

fun setShapeBg(
    view: View, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view, getDrawable(
            GradientDrawable.RECTANGLE, orientation, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setShapeBg(
    view: View, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, radius: FloatArray?
) {
    ViewCompat.setBackground(view, getDrawable(shape, orientation, bgColor, 0, 0, radius))
}

fun setShapeBg(
    view: View, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view,
        getDrawable(shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 设置与状态关联的背景 -> 有相同圆角的纯色背景
 * @param view
 * @param state
 * @param bgColor
 * @param radius
 */
fun setSelectorBg(view: View, state: Int, bgColor: IntArray?, radius: Int) {
    ViewCompat.setBackground(view, getDrawable(state, GradientDrawable.RECTANGLE, bgColor, radius))
}

fun setSelectorBg(
    view: View, state: Int, bgColor: IntArray?,
    borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(view: View, state: Int, shape: Int, bgColor: IntArray?, radius: Int) {
    ViewCompat.setBackground(view, getDrawable(state, shape, bgColor, radius))
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, bgColor: IntArray?,
    borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 设置与状态关联的背景 -> 有不同圆角的纯色背景
 * @param view
 * @param state
 * @param bgColor
 * @param radius
 */
fun setSelectorBg(view: View, state: Int, bgColor: IntArray?, radius: FloatArray?) {
    ViewCompat.setBackground(view, getDrawable(state, GradientDrawable.RECTANGLE, bgColor, radius))
}

fun setSelectorBg(
    view: View, state: Int, bgColor: IntArray?,
    borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(view: View, state: Int, shape: Int, bgColor: IntArray?, radius: FloatArray?) {
    ViewCompat.setBackground(view, getDrawable(state, shape, bgColor, radius))
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, bgColor: IntArray?,
    borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 设置与状态关联的背景 -> 有相同圆角的渐变背景
 * @param view
 * @param state
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 */
fun setSelectorBg(
    view: View, state: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, orientation, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(
    view: View, state: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, orientation, bgColor,
            borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 设置与状态关联的背景 -> 有不同圆角的渐变背景
 * @param view
 * @param state
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 */
fun setSelectorBg(
    view: View, state: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, orientation,
            bgColor, borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(
    view: View, state: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view, getDrawable(
            state, GradientDrawable.RECTANGLE, orientation,
            bgColor, borderColor, borderWidth, radius
        )
    )
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

fun setSelectorBg(
    view: View, state: Int, shape: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
) {
    ViewCompat.setBackground(
        view,
        getDrawable(state, shape, orientation, bgColor, borderColor, borderWidth, radius)
    )
}

/**
 * 根据View状态设置不同的背景
 * @param view
 * @param state
 * @param resId 可为color, drawable
 */
fun setSelectorBg(view: View, state: Int, resId: IntArray?) {
    ViewCompat.setBackground(view, getDrawable(view.context, state, resId))
}

/**
 * 获取通过资源文件构造的背景
 * @param context
 * @param state
 * @param resId
 * @return
 */
fun getDrawable(context: Context?, state: Int, @DrawableRes resId: IntArray?): Drawable? {
    require(!(resId == null || resId.size < MIN_RESOURCE_COUNT))
    if (context != null && context.resources != null) {
        val drawable = StateListDrawable()
        drawable.addState(intArrayOf(state), ContextCompat.getDrawable(context, resId[1]))
        drawable.addState(intArrayOf(), ContextCompat.getDrawable(context, resId[0]))
        return drawable
    }
    return null
}

fun getDrawable(bgColor: Int, radius: Int): Drawable? {
    return getDrawable(GradientDrawable.RECTANGLE, bgColor, 0, 0, radius)
}

fun getDrawable(shape: Int, bgColor: Int, radius: Int): Drawable? {
    return getDrawable(shape, bgColor, 0, 0, radius)
}

fun getDrawable(bgColor: Int, radius: FloatArray?): Drawable? {
    return getDrawable(GradientDrawable.RECTANGLE, bgColor, 0, 0, radius)
}

fun getDrawable(shape: Int, bgColor: Int, radius: FloatArray?): Drawable? {
    return getDrawable(shape, bgColor, 0, 0, radius)
}

fun getDrawable(state: Int, shape: Int, bgColor: IntArray?, radius: Int): Drawable? {
    return getDrawable(state, shape, bgColor, IntArray(2), 0, radius)
}

fun getDrawable(state: Int, shape: Int, bgColor: IntArray?, radius: FloatArray?): Drawable? {
    return getDrawable(state, shape, bgColor, IntArray(2), 0, radius)
}

fun getDrawable(
    bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: Int
): Drawable? {
    return getDrawable(GradientDrawable.RECTANGLE, bgColor, borderColor, borderWidth, radius)
}

/**
 * 获取构造的纯色背景 -> 具有相同圆角的场景
 * @param shape 表示背景形状，取值为：
 * GradientDrawable.RECTANGLE: 表示矩形
 * GradientDrawable.OVAL: 表示圆形
 * GradientDrawable.LINE: 表示线条
 * @param bgColor 背景颜色
 * @param borderColor 边框颜色
 * @param borderWidth 边框宽度
 * @param radius 圆角大小
 * @return
 */
fun getDrawable(
    shape: Int, bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: Int
): Drawable? {
    val drawable = GradientDrawable()
    drawable.shape = shape
    drawable.setColor(bgColor)
    drawable.setStroke(borderWidth, borderColor)
    drawable.cornerRadius = radius.toFloat()
    return drawable
}

/**
 * 获取构造的纯色背景 -> 圆角有差异的场景
 * @param shape
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius 圆角大小，是一个包含8个元素的数组，每2个表示一个圆角，顺序依次为左上，右上，右下，左下
 * @return
 */
fun getDrawable(
    shape: Int, bgColor: Int, borderColor: Int,
    borderWidth: Int, radius: FloatArray?
): Drawable? {
    val drawable = GradientDrawable()
    drawable.shape = shape
    drawable.setColor(bgColor)
    drawable.setStroke(borderWidth, borderColor)
    drawable.cornerRadii = radius
    return drawable
}

/**
 * 获取构造的渐变背景 -> 具有相同圆角的场景
 * @param shape
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: Int
): Drawable? {
    val drawable = GradientDrawable(orientation, bgColor)
    drawable.shape = shape
    drawable.setStroke(borderWidth, borderColor)
    drawable.cornerRadius = radius.toFloat()
    return drawable
}

/**
 * 获取构造的渐变背景 -> 圆角有差异的场景
 * @param shape
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: IntArray?, borderColor: Int, borderWidth: Int, radius: FloatArray?
): Drawable? {
    val drawable = GradientDrawable(orientation, bgColor)
    drawable.shape = shape
    drawable.setStroke(borderWidth, borderColor)
    drawable.cornerRadii = radius
    return drawable
}

/**
 * 获取构造的纯色背景 -> 与状态相关联的背景【有相同圆角】
 * @param state 取值为：android.R.attr.*
 * public static final int state_above_anchor = 16842922;
 * public static final int state_accelerated = 16843547;
 * public static final int state_activated = 16843518;
 * public static final int state_active = 16842914;
 * public static final int state_checkable = 16842911;
 * public static final int state_checked = 16842912;
 * public static final int state_drag_can_accept = 16843624;
 * public static final int state_drag_hovered = 16843625;
 * public static final int state_empty = 16842921;
 * public static final int state_enabled = 16842910;
 * public static final int state_expanded = 16842920;
 * public static final int state_first = 16842916;
 * public static final int state_focused = 16842908;
 * public static final int state_hovered = 16843623;
 * public static final int state_last = 16842918;
 * public static final int state_long_pressable = 16843324;
 * public static final int state_middle = 16842917;
 * public static final int state_multiline = 16843597;
 * public static final int state_pressed = 16842919;
 * public static final int state_selected = 16842913;
 * public static final int state_single = 16842915;
 * public static final int state_window_focused = 16842909;
 *
 * @param shape
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    state: Int,
    shape: Int,
    bgColor: IntArray?,
    borderColor: IntArray,
    borderWidth: Int,
    radius: Int
): Drawable? {
    require(!(bgColor == null || bgColor.size < MIN_RESOURCE_COUNT))
    val drawable = StateListDrawable()
    // addState第一个参数设置为new int[]{}或者new int[] {-state}表示默认状态
    drawable.addState(
        intArrayOf(state), getDrawable(
            shape,
            bgColor[1], borderColor[1], borderWidth, radius
        )
    )
    drawable.addState(
        intArrayOf(), getDrawable(
            shape,
            bgColor[0], borderColor[0], borderWidth, radius
        )
    )
    return drawable
}

/**
 * 获取构造的纯色背景 -> 与状态相关联的背景【圆角有差异的场景】
 * @param state
 * @param shape
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    state: Int,
    shape: Int,
    bgColor: IntArray?,
    borderColor: IntArray,
    borderWidth: Int,
    radius: FloatArray?
): Drawable? {
    require(!(bgColor == null || bgColor.size < MIN_RESOURCE_COUNT))
    val drawable = StateListDrawable()
    drawable.addState(
        intArrayOf(state), getDrawable(
            shape,
            bgColor[1], borderColor[1], borderWidth, radius
        )
    )
    drawable.addState(
        intArrayOf(), getDrawable(
            shape,
            bgColor[0], borderColor[0], borderWidth, radius
        )
    )
    return drawable
}

/**
 * 获取构造的渐变背景 -> 与状态相关联的背景【圆角相同的场景】
 * @param state
 * @param shape
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    state: Int, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
): Drawable? {
    return getDrawable(
        state, shape, arrayOf(orientation, orientation),
        bgColor, borderColor, borderWidth, radius
    )
}

fun getDrawable(
    state: Int, shape: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: Int
): Drawable? {
    require(!(bgColor == null || bgColor.size < MIN_RESOURCE_COUNT))
    val drawable = StateListDrawable()
    drawable.addState(
        intArrayOf(state), getDrawable(
            shape,
            orientation[1], bgColor[1], borderColor[1], borderWidth, radius
        )
    )
    drawable.addState(
        intArrayOf(), getDrawable(
            shape,
            orientation[0], bgColor[0], borderColor[0], borderWidth, radius
        )
    )
    return drawable
}

/**
 * 获取构造的渐变背景 -> 与状态相关联的背景【圆角有差异的场景】
 * @param state
 * @param shape
 * @param orientation
 * @param bgColor
 * @param borderColor
 * @param borderWidth
 * @param radius
 * @return
 */
fun getDrawable(
    state: Int, shape: Int, orientation: GradientDrawable.Orientation?,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
): Drawable? {
    return getDrawable(
        state, shape, arrayOf(orientation, orientation),
        bgColor, borderColor, borderWidth, radius
    )
}

fun getDrawable(
    state: Int, shape: Int, orientation: Array<GradientDrawable.Orientation?>,
    bgColor: Array<IntArray?>?, borderColor: IntArray, borderWidth: Int, radius: FloatArray?
): Drawable? {
    require(!(bgColor == null || bgColor.size < MIN_RESOURCE_COUNT))
    val drawable = StateListDrawable()
    drawable.addState(
        intArrayOf(state), getDrawable(
            shape,
            orientation[1], bgColor[1], borderColor[1], borderWidth, radius
        )
    )
    drawable.addState(
        intArrayOf(), getDrawable(
            shape,
            orientation[0], bgColor[0], borderColor[0], borderWidth, radius
        )
    )
    return drawable
}

/**
 * @param textView
 * @param state
 * @param textColor textColor[0]表示状态为true时的颜色，textColor[1]表示正常状态下的颜色
 */
fun setTextColor(textView: TextView, state: Int, textColor: IntArray?) {
    val colorState = ColorStateList(arrayOf(intArrayOf(state), intArrayOf()), textColor)
    textView.setTextColor(colorState)
}

/**
 * 创建分割线
 * @param color
 * @param width
 * @param height
 * @return
 */
fun getDivider(color: Int, width: Int, height: Int): Drawable? {
    return object : ColorDrawable(color) {
        override fun getIntrinsicWidth(): Int {
            return if (width != 0) width else super.getIntrinsicWidth()
        }

        override fun getIntrinsicHeight(): Int {
            return if (height != 0) height else super.getIntrinsicHeight()
        }
    }
}