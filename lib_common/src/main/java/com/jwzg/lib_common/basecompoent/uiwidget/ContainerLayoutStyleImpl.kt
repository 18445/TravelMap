package com.jwzg.lib_common.basecompoent.uiwidget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.jwzg.lib_common.R
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_NONE
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_NORMAL
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_TRANSLUCENT
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_TRANSPARENT
import com.jwzg.lib_common.utils.setShapeBg

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.uiwidget
 * @ClassName:      ContainerLayoutStyleImpl
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 17:53:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    实现UI样式的基本实现类
 */
class ContainerLayoutStyleImpl(private val context: Context) : ContainerLayoutStyle{

    var toolbar: ToolbarExt? = null
    private var containerLayout: ViewGroup? = null

    override fun initLayout(toolbarStyle: Int) {
        when (toolbarStyle) {
            TOOL_BAR_STYLE_NONE -> containerLayout = FrameLayout(context)
            TOOL_BAR_STYLE_NORMAL -> containerLayout = createNormalToolbarLayout()
            TOOL_BAR_STYLE_TRANSPARENT -> containerLayout = createTransparentToolbarLayout(true)
            TOOL_BAR_STYLE_TRANSLUCENT -> containerLayout = createTransparentToolbarLayout(false)
            else -> {}
        }
    }

    fun getContainerLayout(): ViewGroup? {
        return containerLayout
    }

    private fun createNormalToolbarLayout(): ViewGroup? {
        val containerLayout = LinearLayout(context)
        containerLayout.orientation = LinearLayout.VERTICAL
        toolbar = ToolbarExt(context)
        containerLayout.addView(toolbar)
        return containerLayout
    }

    private fun createTransparentToolbarLayout(isTransparent: Boolean): ViewGroup? {
        val containerLayout = FrameLayout(context)
        toolbar = ToolbarExt(context)
        if (isTransparent) {
            toolbar!!.setBackgroundColor(Color.TRANSPARENT)
        } else {
            setShapeBg(
                toolbar!!, GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                    ContextCompat.getColor(context, R.color.black_50), Color.TRANSPARENT
                ), 0
            )
        }
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            context.resources.getDimensionPixelOffset(R.dimen.toolbar_height)
        )
        containerLayout.addView(toolbar, params)
        return containerLayout
    }

}