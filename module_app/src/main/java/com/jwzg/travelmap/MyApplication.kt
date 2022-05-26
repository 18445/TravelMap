package com.jwzg.travelmap

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.jwzg.lib_common.BuildConfig
import com.jwzg.lib_common.basecompoent.BaseApp
import com.jwzg.lib_common.network.RetrofitClient
import com.jwzg.travelmap.spi.SdkManager
import com.mredrock.cyxbs.spi.SdkService
import java.util.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.travelmap
 * @ClassName:      MyApplication
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 19:05:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    全局Application
 */
class MyApplication : BaseApp(), SdkManager {

    private val loader = ServiceLoader.load(SdkService::class.java)

    override fun onCreate() {
        super.onCreate()
        //如果是在主进程，遍历所有的SdkService实现类的onMainProcess
        loader.takeIf {
            isMainProcess()
        }?.forEach {
            it.onMainProcess(this)
        } ?:
        //如果是在子进程，通过isSdkProcess匹配对应SdkService实现类，最后调用onSdkProcess方法。
        loader.firstOrNull {
            it.isSdkProcess(this)
        }?.onSdkProcess(this)
    }

    override val application: Application
        get() = this

}