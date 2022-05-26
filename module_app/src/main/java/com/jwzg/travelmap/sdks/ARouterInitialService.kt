package com.jwzg.travelmap.sdks

import com.jwzg.travelmap.spi.SdkManager
import com.mredrock.cyxbs.spi.SdkService


/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.travelmap.sdks
 * @ClassName:      ARouterInitialService
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 20:48:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    Arouter的初始化
 */

//@AutoService(SdkService::class)
//class ARouterInitialService : SdkService {
//    override fun onMainProcess(manager: SdkManager) {
//        if (BuildConfig.DEBUG) {
//            ARouter.openDebug()
//            ARouter.openLog()
//        }
//        ARouter.init(manager.application)
//    }
//}