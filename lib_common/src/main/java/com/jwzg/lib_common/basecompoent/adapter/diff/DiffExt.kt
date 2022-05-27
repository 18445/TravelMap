package com.jwzg.lib_common.basecompoent.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.jwzg.lib_common.basecompoent.adapter.core.ListAdapter
import com.jwzg.lib_common.basecompoent.adapter.diff.ArrayListAdapterCallBack
import com.jwzg.lib_common.basecompoent.adapter.diff.ViewModelDiffType

/**
 *
 * @ClassName:      DiffExt
 * @Author:         Yan
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    DiffExt
 */

fun ListAdapter.calculateDiff(
    newItems: List<ViewModelDiffType>
) {
    val result = DiffUtil.calculateDiff(
        ArrayListAdapterCallBack(
            oldItems = dataList as? List<ViewModelDiffType>
                ?: throw Exception("please let model implements SameModel"),
            newItems = newItems
        )
    )
    replaceAll(newItems)
    result.dispatchUpdatesTo(this)
}
