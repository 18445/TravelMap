package com.jwzg.lib_common.basecompoent.uiwidget

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.uiwidget
 * @ClassName:      ContainerLayoutStyle
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 17:50:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    UI界面的基本样式
 */
interface ContainerLayoutStyle {

    companion object{
        /**
         * 没有Toolbar
         */
        const val TOOL_BAR_STYLE_NONE = 0

        /**
         * 白色背景的Toolbar
         */
        const val TOOL_BAR_STYLE_NORMAL = 1

        /**
         * 透明的Toolbar
         */
        const val TOOL_BAR_STYLE_TRANSPARENT = 2

        /**
         * 半透明的Toolbar
         */
        const val TOOL_BAR_STYLE_TRANSLUCENT = 3
    }

    /**
     * 根据Toolbar的样式设置相应的布局
     * @param toolbarStyle
     */
    fun initLayout(toolbarStyle: Int)

}