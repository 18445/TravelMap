package com.jwzg.lib_common.basecompoent.adapter.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @ClassName:      ViewModelExt
 * @Author:         Yan
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    DefaultViewModel ViewModel默认实现
 */

abstract class DefaultViewModel<M> : ViewModel<M, DefaultViewHolder> {

    override var model: M? = null
    private var initView: ViewHolderType? = null
    override var isFirstInit: Boolean = true

    open fun onCreateViewHolder(f: ViewHolderType){
        initView = f
    }

    abstract fun getHolderItemView(parent:ViewGroup,layoutInflater: LayoutInflater):View

    open fun getViewHolder(v : View) = DefaultViewHolder(v)
    override fun getViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): DefaultViewHolder {
        return getViewHolder(getHolderItemView(parent, layoutInflater)).apply {
            initView?.invoke(this)
        }
    }
}

/**
 * 根据XML设置
 */
open class LayoutViewModel<M>(override val layoutRes:Int) : DefaultViewModel<M>(){
    override fun getHolderItemView(parent: ViewGroup, layoutInflater: LayoutInflater): View {
        return layoutInflater.inflate(layoutRes,parent,false)
    }
}

