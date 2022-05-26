package com.jwzg.lib_common.network

import com.jwzg.lib_common.BuildConfig
import com.jwzg.lib_common.config.HttpConstant
import com.jwzg.lib_common.config.HttpConstant.DEFAULT_READ_TIME
import com.jwzg.lib_common.config.HttpConstant.DEFAULT_WRITE_TIME
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.network
 * @ClassName:      RetrofitClient
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 20:37:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    Retrofit客户端
 */

object RetrofitClient {

    //请求的地址
    const val BASE_URL = "TODO"

    //retrofit对象
    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //请求的api，可以根据不同的场景设置多个
    fun <T> getService(apiService : Class<T>) : T = retrofit.create(apiService)

    /**
     * 获取 OkHttpClient
     */
    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .connectTimeout(HttpConstant.DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)//连接超时时间
            .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)//设置写操作超时时间
            .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)//设置读操作超时时间
            .addInterceptor(getHttpLoggingInterceptor())

        return builder.build()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.BASIC
        }
        return logging
    }

}