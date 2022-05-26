package com.jwzg.lib_common.network



import com.google.gson.JsonParseException
import com.jwzg.lib_common.utils.toast
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException


/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.network
 * @ClassName:      HttpError
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 18:55:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    网络请求异常的封装
 */

//异常情况
enum class HttpError(var code: Int, var errorMsg: String) {
    TOKEN_EXPIRE(3001, "token is expired"),
    PARAMS_ERROR(4003, "params is error"),
    //...
}

//对网络请求异常的统一处理

internal fun handlingApiExceptions(code: Int?, errorMsg: String?) = when (code) {
    HttpError.TOKEN_EXPIRE.code -> toast(HttpError.TOKEN_EXPIRE.errorMsg)
    HttpError.PARAMS_ERROR.code -> toast(HttpError.PARAMS_ERROR.errorMsg)
    else -> errorMsg?.let { toast(it) }
}

internal fun handlingExceptions(e: Throwable) = when (e) {

    is HttpException -> toast(e.message())

    is CancellationException -> {

    }

    is SocketTimeoutException -> {
    }

    is JsonParseException -> {
    }

    else -> {
    }

}

