package com.jwzg.lib_common.utils

import android.widget.Toast
import com.jwzg.lib_common.basecompoent.BaseApp

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      ToastUtils
 * @Author:         Yan
 * @CreateDate:     2022年05月26日 18:59:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    toast的工具类
 */

fun toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(BaseApp.appContext, message, duration).show()
}