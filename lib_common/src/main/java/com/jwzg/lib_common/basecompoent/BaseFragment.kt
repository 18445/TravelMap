package com.jwzg.lib_common.basecompoent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


/**
 * ...
 * @author 1799796122 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2022/5/27
 * @Description:fragment抽离
 */
abstract class BaseFragment<VM : ViewModel, VDB : ViewDataBinding> :
    Fragment() {
    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: VDB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mBinding.lifecycleOwner = this
        //获得泛型参数的实际类型
        val vmClass =
            (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
        mViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(this.activity?.application!!)
        ).get(vmClass)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterCreate()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun afterCreate()

    /**
     * 保证同一按钮在1秒内只响应一次点击事件
     */
    abstract class OnSingleClickListener : View.OnClickListener {
        private var lastClickTime: Long = 0
        abstract fun onSingleClick(view: View?)
        override fun onClick(v: View) {
            val curClickTime = System.currentTimeMillis()
            if (curClickTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {
                lastClickTime = curClickTime
                onSingleClick(v)
            }
        }

        companion object {
            //两次点击按钮的最小间隔，目前为1000
            private const val MIN_CLICK_DELAY_TIME = 1000
        }
    }

    /**
     * 同一按钮在短时间内可重复响应点击事件
     */
    abstract class OnMultiClickListener : View.OnClickListener {
        abstract fun onMultiClick(view: View?)
        override fun onClick(v: View) {
            onMultiClick(v)
        }
    }
}