package com.jwzg.lib_common.utils

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.inputmethod.InputMethodManager
import android.widget.ScrollView

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      InputMethodUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 18:57:00
 * @UpdateRemark:   更新说明： 扩展函数更新
 * @Version:        1.1
 * @Description:    键盘的相关操作
 */

/**
 * 键盘的最小高度
 */
private const val MINI_KEYBOARD_HEIGHT = 180


/**
 * 切换菜单，显示时调用则隐藏，隐藏时调用则显示
 * @param context
 */
fun Context.toggleKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(0, 0)
}

/**
 * 隐藏键盘
 * @param context
 */
fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = this.currentFocus
    if (view != null) {
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

/**
 * 设置某个view的focusable和touchFocusable为true, 然后调用此方法
 * @param context
 */
fun Activity.showKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = this.currentFocus
    if (view != null) {
        imm.showSoftInput(view, 0)
    }
}

/**
 * 显示键盘
 * @param context
 * @param view
 */
fun showKeyboard(context: Context, view: View?) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, 0)
}

/**
 * 键盘弹出时调整EditText的位置
 * @param view 需要调整位置的View， 一般为根布局
 * @param focusView 当前获取焦点的EditText
 */
fun adjustViewPosition(view: View, focusView: View) {
    adjustViewPosition(view, focusView, 0)
}

fun adjustViewPosition(view: View, focusView: View, offsetY: Int) {
    view.viewTreeObserver.addOnGlobalLayoutListener(OnGlobalLayoutListener {
        if ((view.context as Activity).currentFocus !== focusView) {
            return@OnGlobalLayoutListener
        }
        val outRect = Rect()
        view.getWindowVisibleDisplayFrame(outRect)
        val screenHeight = view.rootView.height
        val softKeyboardHeight = screenHeight - outRect.bottom
        if (softKeyboardHeight > MINI_KEYBOARD_HEIGHT) {
            val scrollY = if (offsetY != 0) offsetY else softKeyboardHeight
            view.post {
                if (view is ScrollView) {
                    view.smoothScrollBy(0, scrollY)
                } else {
                    view.scrollBy(0, scrollY)
                }
            }
        } else {
            view.scrollTo(0, 0)
        }
    })
}