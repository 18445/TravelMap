package com.jwzg.lib_common.basecompoent.adapter.core

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @ClassName:      ViewmodelFactory
 * @Author:         Yan
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */

//ViewHolder工厂
interface ViewHolderFactory <VH : RecyclerView.ViewHolder> {
    fun getViewHolder(parent : ViewGroup, layoutInflater: LayoutInflater) : VH
}

//ViewHolder的缓存
interface ViewHolderFactoryCache<VHF : ViewHolderFactory<*>>{
    fun register(type:Int,item:VHF): Boolean
    operator fun get(type : Int) : VHF //解构声明
    fun contains(type : Int ) : Boolean
    fun clear()
}

//默认的缓存实现类
class DefaultViewHolderFactoryCache : ViewHolderFactoryCache<ViewModelType> {
    private val typeInstances = SparseArray<ViewModelType>()
    override fun register(type:Int,item: ViewModelType) : Boolean{
        if(!contains(type)){
            typeInstances.put(type,item)
            return true
        }
        return false
    }

    override fun get(type : Int) : ViewModelType {
        return typeInstances.get(type)
    }
    override fun contains(type: Int): Boolean = typeInstances.indexOfKey(type) >= 0

    override fun clear() {
        typeInstances.clear()
    }
}