package com.jwzg.lib_common.network

import java.io.Serializable

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.network
 * @ClassName:      ApiResponse
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 18:49:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    网络请求返回的数据类型
 */

//返回的数据类型
open class ApiResponse<out T>(
    open val data: T? = null,
    open val code: Int? = null,
    open val msg: String? = null,
    open val error: Throwable? = null,
) : Serializable {
    val isSuccess: Boolean
        get() = code == 0 || code == 200
}

//返回的数据为空类型
class ApiEmptyResponse<T> : ApiResponse<T>()

//成功返回的类型
data class ApiSuccessResponse<T>(val response: T) : ApiResponse<T>(data = response)

//失败返回的类型
data class ApiFailedResponse<T>(override val code: Int?, override val msg: String?) : ApiResponse<T>(code = code, msg = msg)

//网络请求错误的类型
data class ApiErrorResponse<T>(val throwable: Throwable) : ApiResponse<T>(error = throwable)