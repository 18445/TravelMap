package com.jwzg.lib_common.basecompoent.adapter.binding

import com.jwzg.lib_common.basecompoent.adapter.core.DefaultViewHolder


/**
 *
 * @ClassName:      DSL
 * @Author:         Yan
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    bindingViewModelDsl
 */

inline fun <M> bindingViewModelDsl(
    layoutRes: Int,
    variableId: Int,
    model:M,
    crossinline init: DefaultViewHolder.() -> Unit
): BindingViewModel<M> {
    return BindingViewModel<M>(layoutRes, variableId).apply {
        this.model = model
        onCreateViewHolder{
            init.invoke(this)
        }
    }
}