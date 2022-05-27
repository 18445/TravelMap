package com.jwzg.lib_common.basecompoent.processor

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.jwzg.lib_common.R
import com.jwzg.lib_common.basecompoent.processor.RequestProcessor.Companion.MSG_LOAD_EMPTY
import com.jwzg.lib_common.basecompoent.processor.RequestProcessor.Companion.MSG_LOAD_FAILURE
import com.jwzg.lib_common.basecompoent.processor.RequestProcessor.Companion.MSG_LOAD_FINISH
import com.jwzg.lib_common.basecompoent.processor.RequestProcessor.Companion.MSG_LOAD_NO_LOGIN
import com.jwzg.lib_common.basecompoent.processor.RequestProcessor.Companion.MSG_NO_MORE
import com.jwzg.lib_common.utils.toast

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.processor
 * @ClassName:      RequestProcessorImpl
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 19:39:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    网络请求过程中页面的处理过程
 */
class RequestProcessorImpl (val context: Context): RequestProcessor{
    private var containerLayout: ViewGroup? = null
    private var exceptionLayout: View? = null
    private var loadingLayout: View

    private var exceptionLayoutType = 0
    private var refreshListener: View.OnClickListener? = null
    private var showLayoutListener: OnShowContentLayoutListener? = null
    private val params = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )

    companion object {
        /**
         * 失败时的布局
         */
        private const val LAYOUT_TYPE_FAILURE = 1

        /**
         * 数据为空时的布局
         */
        private const val LAYOUT_TYPE_EMPTY = 2

        /**
         * 需要登录时的布局
         */
        private const val LAYOUT_TYPE_LOGIN = 3

    }

    private val handler : Handler = object : Handler(Looper.myLooper()!!) {
        override fun handleMessage(msg: Message) {
            handleMsg(msg)
        }
    }


    init {
        loadLoadingLayout().also { loadingLayout = it }
    }

    fun getLoadingLayout(): View {
        return loadingLayout
    }

    fun setContainerLayout(containerLayout: ViewGroup?) {
        this.containerLayout = containerLayout
    }

    fun notifyLoadFinish(msg: Int) {
        handler.sendEmptyMessage(msg)
    }

    fun handleMsg(msg: Message) {
        when (msg.what) {
            MSG_LOAD_FINISH -> if (showLayoutListener != null) {
                showLayoutListener!!.onShowContentLayout()
            }
            MSG_LOAD_FAILURE -> showExceptionLayout(LAYOUT_TYPE_FAILURE)
            MSG_LOAD_EMPTY -> showExceptionLayout(LAYOUT_TYPE_EMPTY)
            MSG_NO_MORE -> toast("没有更多数据啦")
            MSG_LOAD_NO_LOGIN -> showExceptionLayout(Companion.LAYOUT_TYPE_LOGIN)
            else -> throw IllegalArgumentException("The Message not supported!")
        }
    }

    /**
     * 网络请求完成后更换布局
     * @param oldView
     * @param newView
     */
    fun updateContentView(oldView: View?, newView: View?) {
        if (containerLayout != null) {
            val index = containerLayout!!.indexOfChild(oldView)
            containerLayout!!.removeView(oldView)
            containerLayout!!.addView(newView, index, params)
        } else {
            (context as Activity?)!!.setContentView(newView)
        }
    }

    /**
     * 网络请求失败时的刷新操作 调用requestData
     * @param listener
     */
    fun setRefreshListener(listener: View.OnClickListener?) {
        refreshListener = listener
    }

    fun setOnShowContentLayoutListener(showLayoutListener: OnShowContentLayoutListener?) {
        this.showLayoutListener = showLayoutListener
    }

    fun showExceptionLayout(layoutType: Int) {
        if (exceptionLayout == null || exceptionLayoutType != layoutType) {
            if (layoutType == Companion.LAYOUT_TYPE_EMPTY) {
                exceptionLayout = loadEmptyLayout()
                exceptionLayout!!.setOnClickListener { v ->
                    if (refreshListener != null) {
                        refreshListener!!.onClick(v)
                    }
                    updateContentView(exceptionLayout, loadingLayout)
                }
            } else if (layoutType == Companion.LAYOUT_TYPE_FAILURE) {
                exceptionLayout = loadFailureLayout()
                exceptionLayout!!.setOnClickListener { v ->
                    if (refreshListener != null) {
                        refreshListener!!.onClick(v)
                    }
                    updateContentView(exceptionLayout, loadingLayout)
                }
            } else if (layoutType == Companion.LAYOUT_TYPE_LOGIN) {
                exceptionLayout = loadLoginLayout()
                exceptionLayout!!.setOnClickListener {
                    toast("跳转到登录页面")
                    updateContentView(exceptionLayout, loadingLayout)
                }
            }
        }
        exceptionLayoutType = layoutType
        updateContentView(loadingLayout, exceptionLayout)
    }

    override fun loadLoadingLayout(): View {
        return View.inflate(context, R.layout.common_progress_layout, null)
    }

    override fun loadEmptyLayout(): View {
        return View.inflate(context, R.layout.common_empty_layout, null)
    }

    override fun loadFailureLayout(): View {
        return View.inflate(context, R.layout.common_failure_layout, null)
    }

    override fun loadLoginLayout(): View {
        return View.inflate(context, R.layout.common_login_layout, null)
    }

    interface OnShowContentLayoutListener {
        /**
         * 开始加载布局
         */
        fun onShowContentLayout()
    }


}