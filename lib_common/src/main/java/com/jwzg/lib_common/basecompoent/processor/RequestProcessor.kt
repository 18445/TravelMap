package com.jwzg.lib_common.basecompoent.processor

import android.view.View

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.processor
 * @ClassName:      RequestProcessor
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 19:38:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    需要进行网络请求过程的接口
 */
interface RequestProcessor {
    companion object{

        /**
         * 数据请求成功
         */
        var MSG_LOAD_FINISH = 0x100

        /**
         * 网络请求失败
         */
        var MSG_LOAD_FAILURE = 0x101

        /**
         * 数据为空
         */
        var MSG_LOAD_EMPTY = 0x102

        /**
         * 没有更多数据
         */
        var MSG_NO_MORE = 0x104

        /**
         * 未登录
         */
        var MSG_LOAD_NO_LOGIN = 0x105

    }

    /**
     * 加载加载中布局
     * @return
     */
    fun loadLoadingLayout(): View

    /**
     * 加载数据为空时的布局
     * @return
     */
    fun loadEmptyLayout(): View

    /**
     * 加载网络请求为空时的布局
     * @return
     */
    fun loadFailureLayout(): View

    /**
     * 加载需要未登录时的布局
     * @return
     */
    fun loadLoginLayout(): View
}