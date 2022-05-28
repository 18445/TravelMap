package com.jwzg.lib_common.utils

import kotlin.math.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      DistanceUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:44:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    根据两点经纬度获得直线距离
 */
/**
 * 地球半径
 */
private const val EARTH_RADIUS = 6378137.0

/**
 * 米与千米的进制
 */
private const val METER_PER_KM = 1000.0

/**
 * 根据经纬度获取距离
 * @param longitude1
 * @param latitude1
 * @param longitude2
 * @param latitude2
 * @return
 */
fun getDistance(
    longitude1: Double, latitude1: Double,
    longitude2: Double, latitude2: Double
): Double {
    val lat = rad(latitude1)
    val lat2 = rad(latitude2)
    val a = lat - lat2
    val b = rad(longitude1) - rad(longitude2)
    var s = 2 * asin(
        sqrt(
            sin(a / 2).pow(2.0)
                    + (cos(lat) * cos(lat2)
                    * sin(b / 2).pow(2.0))
        )
    )
    s *= EARTH_RADIUS
    s = ((s * 10000).roundToInt() / 10000).toDouble()
    return s
}

private fun rad(d: Double): Double {
    return d * Math.PI / 180.0
}

/**
 * 根据经纬度获取距离
 * @param longitude1
 * @param latitude1
 * @param longitude2
 * @param latitude2
 * @return
 */
fun getDistanceString(
    longitude1: Double, latitude1: Double,
    longitude2: Double, latitude2: Double
): String {
    val distanceStr: String
    val distance = getDistance(longitude1, latitude1, longitude2, latitude2)
    distanceStr = if (distance < METER_PER_KM) {
        "距离" + distance.toInt() + "米"
    } else {
        "距离" + (distance / METER_PER_KM).toInt() + "公里"
    }
    return distanceStr
}

/**
 * 根据经纬度获取距离
 * @param longitude1
 * @param latitude1
 * @param longitude2
 * @param latitude2
 * @return
 */
fun getDistanceString(
    longitude1: String, latitude1: String,
    longitude2: String, latitude2: String
): String {
    return getDistanceString(
        stringToDouble(longitude1), stringToDouble(latitude1),
        stringToDouble(longitude2), stringToDouble(latitude2)
    )
}