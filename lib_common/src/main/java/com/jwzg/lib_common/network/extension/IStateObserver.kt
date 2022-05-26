package com.jwzg.lib_common.network.extension

import androidx.lifecycle.Observer
import com.jwzg.lib_common.network.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.network.extension
 * @ClassName:      IStateObserver
 * @Author:         Yan
 * @CreateDate:     2022年05月27日 00:03:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    对ApiResponse的观察并根据返回类型进行回调
 */

abstract class IStateObserver <T> : Observer<ApiResponse<T>> {
    override fun onChanged(apiResponse: ApiResponse<T>?) {
        when (apiResponse) {
            is ApiSuccessResponse -> onSuccess(apiResponse.response)
            is ApiEmptyResponse -> onDataEmpty()
            is ApiFailedResponse -> onFailed(apiResponse.code, apiResponse.msg)
            is ApiErrorResponse -> onError(apiResponse.throwable)
        }
        onComplete()
    }

    abstract fun onSuccess(data: T)

    abstract fun onDataEmpty()

    abstract fun onError(e: Throwable)

    abstract fun onFailed(errorCode: Int?, errorMsg: String?)

    abstract fun onComplete()
}