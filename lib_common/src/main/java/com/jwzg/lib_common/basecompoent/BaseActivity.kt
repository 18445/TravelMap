package com.jwzg.lib_common.basecompoent

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


/**
 * ...
 * @author 1799796122 (Ran Sixiang)
 * @email 1799796122@qq.com
 * @date 2022/5/27
 * @Description:activity抽离
 */
abstract class BaseActivity<VM : ViewModel, VDB : ViewDataBinding> :
    AppCompatActivity() {
    protected lateinit var mViewModel: VM
    protected lateinit var mBinding: VDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        cancelStatusBar()
        afterCreate()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
    protected abstract fun afterCreate()

    /**
     * 状态栏透明（CV自郭神）
     */
    private fun cancelStatusBar() {
        val window = this.window
        val decorView = window.decorView

        // 这是 Android 做了兼容的 Compat 包
        // 下面这个设置后会沉浸式状态栏和导航栏
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val windowInsetsController = ViewCompat.getWindowInsetsController(decorView)
        // 设置状态栏字体颜色为黑色
        windowInsetsController?.isAppearanceLightStatusBars = true
        //把状态栏颜色设置成透明
        window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 保证同一按钮在1秒内只会响应一次点击事件
     */
    abstract class OnSingleClickListener : View.OnClickListener {
        private var lastClickTime: Long = 0
        abstract fun onSingleClick(view: View?)
        override fun onClick(view: View?) {
            val curClickTime = System.currentTimeMillis()
            if (curClickTime - lastClickTime >= MIN_CLICK_DELAY_TIME) {
                lastClickTime = curClickTime
                onSingleClick(view)
            }
        }

        companion object {
            //两次点击按钮之间的间隔，目前为1000ms
            private const val MIN_CLICK_DELAY_TIME = 1000
        }
    }

    /**
     * 同一按钮在短时间内可重复响应点击事件
     */
    abstract class OnMultiClickListener : View.OnClickListener {
        abstract fun onMultiClick(view: View?)
        override fun onClick(v: View?) {
            onMultiClick(v)
        }
    }
}