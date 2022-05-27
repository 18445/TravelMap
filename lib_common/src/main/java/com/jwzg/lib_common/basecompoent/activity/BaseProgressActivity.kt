package com.jwzg.lib_common.basecompoent.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jwzg.lib_common.basecompoent.processor.RequestProcessorImpl
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_NONE
import java.lang.reflect.ParameterizedType

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.activity
 * @ClassName:      BaseProgressActivity
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 19:35:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    需要进行网络请求的Activity基类
 */

abstract class BaseProgressActivity <VM : ViewModel, VDB : ViewDataBinding>
    : BaseCommonActivity(){

    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: VDB

    private lateinit var loadingLayout: View
    private lateinit var processor: RequestProcessorImpl

    /**
     * 内容页面是否已被加载，用于区分第一次加载和刷新
     */
    private var hasLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViews()
        initActivity()

        setContentView(getLayoutId())
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.lifecycleOwner = this
        //获得泛型参数的实际类型
        val vmClass =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel =  ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(this.application)
        ).get(vmClass)
//        cancelStatusBar()
        afterCreate()
    }

    override fun initLayout(toolbarStyle: Int) {
        processor = RequestProcessorImpl(this)
        loadingLayout = processor.getLoadingLayout()
        if (toolbarStyle == TOOL_BAR_STYLE_NONE) {
            setContentView(loadingLayout)
        } else {
            super.initLayout(toolbarStyle)
            processor.setContainerLayout(containerLayout)
            containerLayout.addView(
                loadingLayout, LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            )
        }
        processor.setRefreshListener(View.OnClickListener { requestData() })
        processor.setOnShowContentLayoutListener(object : RequestProcessorImpl.OnShowContentLayoutListener {
            override fun onShowContentLayout() {
                // 是否为初次加载，以区分刷新操作
                if (!hasLoaded) {
                    hasLoaded = true
                    val contentLayout = View.inflate(context, getLayoutResId(), null)
                    processor.updateContentView(loadingLayout, contentLayout)
                    getViews()
                }
                initActivity()
            }
        })
    }

    override fun pretreatment() {
        super.pretreatment()
        requestData()
    }

    /**
     * 网络请求的过程
     */
    protected abstract fun requestData()

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun afterCreate()

    open fun notifyLoadFinish(msg: Int) {
        processor.notifyLoadFinish(msg)
    }

    open fun loadLoadingLayout(): View? {
        return processor.loadLoadingLayout()
    }

    open fun loadEmptyLayout(): View? {
        return processor.loadEmptyLayout()
    }

    open fun loadFailureLayout(): View? {
        return processor.loadFailureLayout()
    }

    open fun loadLoginLayout(): View? {
        return processor.loadLoginLayout()
    }
}