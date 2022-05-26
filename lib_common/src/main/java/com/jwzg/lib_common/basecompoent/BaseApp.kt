package com.jwzg.lib_common.basecompoent

import android.app.Application
import android.content.Context
import androidx.annotation.CallSuper

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.basecompoent
 * @ClassName:      BaseApp
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 19:02:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:     //TODO
 */

abstract class BaseApp : Application() {
    companion object {
        lateinit var appContext: Context
            private set
        lateinit var version:String
            private set
    }

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        appContext = this
        appContext.packageManager.getPackageInfo(appContext.packageName,0).let {
            version = it.versionName
        }
    }
}