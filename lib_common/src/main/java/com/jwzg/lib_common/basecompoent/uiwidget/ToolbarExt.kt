package com.jwzg.lib_common.basecompoent.uiwidget

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import com.jwzg.lib_common.R


/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.uiwidget
 * @ClassName:      ToolbarExt
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 17:55:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    对Toolbar的封装
 */

class ToolbarExt : Toolbar {

    private var titleText: TextView? = null
    private var leftText: TextView? = null
    private var rightText: TextView? = null
    private var rightIcon: ImageView? = null
    private var rightIcons: Array<ImageView> = arrayOf()

    private var toolbarHeight = 0
    private var itemPadding = 0

    constructor(context: Context) : this(context,null)

    constructor(context: Context,attrs: AttributeSet?) : this(context, attrs,0)

    constructor(context: Context,attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs,defStyleAttr) {
        toolbarHeight = resources.getDimensionPixelOffset(R.dimen.toolbar_height)
        itemPadding = resources.getDimensionPixelOffset(R.dimen.toolbar_padding)
        title = ""
        setReturnIcon(R.drawable.nav_back_grey_icon)
        setTitleTextAppearance(context, R.style.NavigationTitleAppearance)
        minimumHeight = toolbarHeight
        setBackgroundColor(Color.WHITE)
        ViewCompat.setElevation(this, resources.getDimension(R.dimen.toolbar_elevation))
    }

    /**
     * 设置返回键的图片资源
     * @param resId
     */
    fun setReturnIcon(@DrawableRes resId: Int) {
        setNavigationIcon(resId)
        setNavigationOnClickListener { (context as Activity).finish() }
    }

    /**
     * 设置返回键的图片资源和点击事件
     * @param resId
     * @param listener
     */
    fun setReturnIconAndEvent(@DrawableRes resId: Int, listener: OnClickListener?) {
        setNavigationIcon(resId)
        setNavigationOnClickListener(listener)
    }

    /**
     * 初始化标题View
     * @param isDefaultStyle
     */
    private fun initTitleText(isDefaultStyle: Boolean) {
        if (titleText == null) {
            titleText = TextView(context)
            if(titleText != null){
                titleText!!.gravity = (Gravity.CENTER)
                if (isDefaultStyle) {
                    setTextStyle(titleText!!, R.style.NavigationTitleAppearance)
                }
                val params = generateDefaultLayoutParams()
                params.gravity = Gravity.LEFT
                addView(titleText, params)
            }
        }
    }

    private fun setTextStyle(textView: TextView, styleId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            textView.setTextAppearance(styleId)
        } else {
            textView.setTextAppearance(context, styleId)
        }
    }

    /**
     * 设置标题
     * @param title
     * @return
     */
    fun setTitle(title: String?): ToolbarExt {
        initTitleText(true)
        titleText!!.text = title
        return this
    }

    /**
     * 调用默认的setTitle
     * @param title
     * @return
     */
    fun setDefaultTitle(title: String?): ToolbarExt {
        super.setTitle(title)
        return this
    }

    fun setTitleGravity(gravity: Int): ToolbarExt {
        initTitleText(true)
        (titleText!!.layoutParams as LayoutParams).gravity = gravity
        return this
    }

    /**
     * 设置标题样式
     * @param styleId
     * @return
     */
    fun setTitleTextAppearance(@StyleRes styleId: Int): ToolbarExt {
        initTitleText(false)
        setTextStyle(titleText!!, styleId)
        return this
    }

    /**
     * 获取标题View
     * @return
     */
    fun getTitleText(): TextView? {
        initTitleText(true)
        return titleText
    }

    /**
     * 初始化左边TextView
     * @param isDefaultStyle
     */
    private fun initLeftText(isDefaultStyle: Boolean) {
        if (leftText == null) {
            leftText = TextView(context)
            if(leftText!=null){
                leftText!!.setPadding(itemPadding, 0, itemPadding, 0)
                leftText!!.gravity = (Gravity.CENTER)
                if (isDefaultStyle) {
                    setTextStyle(leftText!!, R.style.NavigationLeftTextAppearance)
                }
                val params = generateDefaultLayoutParams()
                //params.height = ViewGroup.LayoutParams.MATCH_PARENT;
                params.gravity = Gravity.LEFT or Gravity.CENTER_VERTICAL
                addView(leftText, params)
            }
        }
    }

    /**
     * 设置左边TextView的文案
     * @param text
     * @return
     */
    fun setLeftText(text: String?): ToolbarExt {
        navigationIcon = null
        initLeftText(true)
        leftText!!.text = text
        return this
    }

    /**
     * 设置左边TextView的文案和点击事件
     * @param text
     * @param listener
     * @return
     */
    fun setLeftTextAndEvent(
        text: String?,
        listener: OnClickListener?
    ): ToolbarExt {
        initLeftText(true)
        leftText!!.text = text
        leftText!!.setOnClickListener(listener)
        return this
    }

    /**
     * 设置左边TextView的文字样式
     * @param styleId
     * @return
     */
    fun setLeftTextAppearance(@StyleRes styleId: Int): ToolbarExt {
        initLeftText(false)
        setTextStyle(leftText!!, styleId)
        return this
    }

    /**
     * 获取左边的TextView
     * @return
     */
    fun getLeftText(): TextView? {
        return leftText
    }

    /**
     * 初始化右边的TextView
     * @param isDefaultStyle
     */
    private fun initRightText(isDefaultStyle: Boolean) {
        if (rightText == null) {
            rightText = TextView(context)
            if(rightText != null){
                rightText!!.setPadding(itemPadding, 0, itemPadding, 0)
                rightText!!.gravity = (Gravity.CENTER)
                if (isDefaultStyle) {
                    setTextStyle(rightText!!, R.style.NavigationRightTextAppearance)
                }
                val params = generateDefaultLayoutParams()
                params.gravity = Gravity.RIGHT or Gravity.CENTER_VERTICAL
                addView(rightText, params)
            }
        }
    }

    /**
     * 设置右边TextView的文案
     * @param text
     * @return
     */
    fun setRightText(text: String?): ToolbarExt {
        initRightText(true)
        rightText!!.text = text
        return this
    }

    /**
     * 设置右边View的文案和点击事件
     * @param text
     * @param listener
     * @return
     */
    fun setRightTextAndEvent(
        text: String?,
        listener: OnClickListener?
    ): ToolbarExt {
        initRightText(true)
        rightText!!.text = text
        rightText!!.setOnClickListener(listener)
        return this
    }

    /**
     * 设置右边TextVIew的文字样式
     * @param styleId
     * @return
     */
    fun setRightTextAppearance(@StyleRes styleId: Int): ToolbarExt {
        initRightText(false)
        setTextStyle(rightText!!, styleId)
        return this
    }

    /**
     * 获取右边的TextView
     * @return
     */
    fun getRightText(): TextView? {
        return rightText
    }

    fun setRightIcon(
        @DrawableRes resId: Int,
        listener: OnClickListener?
    ): ToolbarExt {
        return setRightIcon(resId, 0, 0, listener)
    }

    fun setRightIcon(
        @DrawableRes resId: Int,
        horizontalPadding: Int,
        listener: OnClickListener?
    ): ToolbarExt {
        return setRightIcon(resId, horizontalPadding, 0, listener)
    }

    /**
     * 设置右边Icon的资源
     * @param resId
     * @param horizontalPadding
     * @param marginRight 最右边Icon的右边距
     * @param listeners
     * @return
     */
    fun setRightIcon(
        @DrawableRes resId: Int,
        horizontalPadding: Int,
        marginRight: Int,
        listeners: OnClickListener?
    ): ToolbarExt {
        val params = generateDefaultLayoutParams()
        params.rightMargin = marginRight
        params.gravity = Gravity.RIGHT or Gravity.CENTER_VERTICAL
        rightIcon = ImageView(context)
        if(rightIcon != null){
            rightIcon!!.setImageResource(resId)
            rightIcon!!.setPadding(horizontalPadding, 0, horizontalPadding, 0)
            rightIcon!!.setOnClickListener(listeners)
            addView(rightIcon, params)
        }
        return this
    }

    fun getRightIcon(): ImageView? {
        return rightIcon
    }

    fun setRightIcons(
        @DrawableRes resIds: IntArray?,
        listeners: Array<OnClickListener?>?
    ): ToolbarExt {
        return setRightIcons(resIds, 0, 0, listeners)
    }

    fun setRightIcons(
        @DrawableRes resIds: IntArray?,
        horizontalPadding: Int,
        listeners: Array<OnClickListener?>?
    ): ToolbarExt {
        return setRightIcons(resIds, horizontalPadding, 0, listeners)
    }

    /**
     * 设置右边多个Icon资源
     * @param resIds
     * @param horizontalPadding 每个Icon的padding
     * @param marginRight 最右边icon的右边距
     * @param listeners
     * @return
     */
    fun setRightIcons(
        @DrawableRes resIds: IntArray?,
        horizontalPadding: Int,
        marginRight: Int,
        listeners: Array<OnClickListener?>?
    ): ToolbarExt {
        require(!(resIds == null || resIds.isEmpty())) { "resIds can't be null" }
        require(!(listeners == null || listeners.isEmpty())) { "listeners can't be null" }
        require(resIds.size == listeners.size) { "resIds's length should equals listeners's length" }
        val params = generateDefaultLayoutParams()
        params.gravity = Gravity.RIGHT or Gravity.CENTER_VERTICAL
        val rightIconLayout = LinearLayout(context)
        rightIconLayout.setPadding(0, 0, marginRight, 0)
        rightIconLayout.orientation = LinearLayout.HORIZONTAL
        val iconParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        for (i in resIds.indices) {
            rightIcons[i] = ImageView(context)
            rightIcons[i].setPadding(horizontalPadding, 0, horizontalPadding, 0)
            rightIcons[i].setImageResource(resIds[i])
            rightIcons[i].setOnClickListener(listeners[i])
            rightIconLayout.addView(rightIcons[i], iconParams)
        }
        addView(rightIconLayout, params)
        return this
    }

    fun getRightIcons(): Array<ImageView> {
        return rightIcons
    }

    /**
     * 设置背景的透明度
     * @param alpha
     */
    fun setBackgroundAlpha(alpha: Int) {
        setBackgroundColor(Color.argb(alpha, 255, 255, 255))
    }

    fun setChildViewStyle() {
        var i = 0
        val size = childCount
        while (i < size) {
            val itemView = getChildAt(i)
            if (itemView is ImageView) {
                DrawableCompat.setTint(itemView.drawable, Color.WHITE)
            } else if (itemView is TextView) {
                itemView.setTextColor(Color.WHITE)
            }
            i++
        }
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, toolbarHeight)
    }

    /**
     * 判断颜色值是否为暗色调
     * @param color
     * @return
     */
    fun isDarkColor(color: Int): Boolean {
        // 颜色掉的临界值
        val darknessThreshold = 0.5
        val darkness =
            1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
        return darkness < darknessThreshold
    }

}