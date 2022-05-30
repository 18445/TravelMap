package com.jwzg.lib_common.basecompoent.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.jwzg.lib_common.R
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyle.Companion.TOOL_BAR_STYLE_NORMAL
import com.jwzg.lib_common.basecompoent.uiwidget.ContainerLayoutStyleImpl
import com.jwzg.lib_common.basecompoent.uiwidget.ToolbarExt
import com.jwzg.lib_common.utils.hideKeyboard

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent.activity
 * @ClassName:      BaseCommonActivity
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 18:45:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    基础的BaseActivity
 */
abstract class BaseCommonActivity : AppCompatActivity(), ContainerLayoutStyle {
    private lateinit var toolbar: ToolbarExt
    lateinit var containerLayout: ViewGroup

    protected var context: Activity? = null
    private var fragmentManager: FragmentManager? = null
    private var layoutStyle: ContainerLayoutStyleImpl? = null

    private var toolbarStyle: Int = TOOL_BAR_STYLE_NORMAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        fragmentManager = supportFragmentManager
        // 设置沉浸式状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        // 设置Activity的切换动画
        overridePendingTransition(
            R.anim.anim_translate_right_in_300,
            R.anim.anim_translate_left_out_300
        )
        if (savedInstanceState != null) {
            restoreFragment(savedInstanceState)
            recreateActivity(savedInstanceState)
        }
        layoutStyle = ContainerLayoutStyleImpl(this)
        pretreatment()
        initLayout(toolbarStyle)
        setContentView(containerLayout)

    }

    override fun initLayout(toolbarStyle: Int) {
        layoutStyle!!.initLayout(toolbarStyle)
        toolbar = layoutStyle!!.toolbar!!
        containerLayout = layoutStyle!!.getContainerLayout()!!
    }

    /**
     * 预处理，加载布局之前添加相关逻辑，如设置window样式，重置切换动画，设置toolbar风格
     */
    protected open fun pretreatment() {}

    /**
     * 设置toolbar的样式
     * @param style
     */
    protected open fun setToolbarStyle(style: Int) {
        toolbarStyle = style
    }

    /**
     * 获取Activity加载的布局ID
     * @return
     */
    protected abstract fun getLayoutResId(): Int

    /**
     * 获取布局中的所有控件
     */
    protected abstract fun getViews()

    /**
     * Activity的逻辑处理过程
     */
    protected abstract fun initActivity()

    protected open fun recreateActivity(savedInstanceState: Bundle?) {}

    protected open fun needEventBus(): Boolean {
        return false
    }

    /**
     * 当Activity重建时恢复Fragment
     * @param savedInstanceState
     */
    open fun restoreFragment(savedInstanceState: Bundle?) {
        val fm: FragmentManager = supportFragmentManager
        val fragmentList: List<Fragment> = fm.fragments
        if (fragmentList.isEmpty()) {
            return
        }
        for (fragment in fragmentList) {
            fragment.onAttach(context as Context)
            restoreChildFragment(fragment)
        }
    }

    /**
     * 恢复嵌套的Fragment
     */
    open fun restoreChildFragment(currentFragment: Fragment) {
        val fm: FragmentManager = currentFragment.requireFragmentManager()
        val fragmentList: List<Fragment> = fm.fragments
        if (fragmentList.isEmpty()) {
            return
        }
        for (fragment in fragmentList) {
            fragment.onAttach(context as Context)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun finish() {
        super.finish()
        this.hideKeyboard()
        overridePendingTransition(
            R.anim.anim_translate_left_in_300,
            R.anim.anim_translate_right_out_300
        )
    }
}