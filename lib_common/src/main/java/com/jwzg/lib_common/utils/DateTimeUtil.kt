package com.jwzg.lib_common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      DateTimeUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:38:00
 * @UpdateRemark:   更新说明： 扩展函数更新
 * @Version:        1.1
 * @Description:    与时间有关的工具类
 */

/**
 * 每秒的毫秒数
 */
private const val MILLI_SECOND_OF_SECOND: Long = 1000

/**
 * 每分钟的毫秒数
 */
private const val MILLI_SECOND_OF_MINUTE = 60 * MILLI_SECOND_OF_SECOND

/**
 * 每小时的毫秒数
 */
private const val MILLI_SECOND_OF_HOUR = 60 * MILLI_SECOND_OF_MINUTE

/**
 * 每天的毫秒数
 */
private const val MILLI_SECOND_OF_DAY = 24 * MILLI_SECOND_OF_HOUR

/**
 * 星期的中文描述
 */
private val WEEKS = arrayOf("日", "一", "二", "三", "四", "五", "六")

/**
 * 将秒转换成指定格式的日期
 * @param second
 * @param format
 * @return
 */
fun Long.formatDate( format: String): String {
    val sdf = SimpleDateFormat(format, Locale.CHINA)
    val date = Date(this * MILLI_SECOND_OF_SECOND)
    return sdf.format(date)
}

/**
 * 将秒转换成指定格式的日期
 * @param second
 * @param format
 * @return
 */
fun String.formatDate(format: String): String {
    return this.toLong().formatDate(format)
}

/**
 * 将日期格式化指定格式
 * @param date
 * @param format
 * @return
 */
fun Date.formatDate(format: String): String {
    val sdf = SimpleDateFormat(format, Locale.CHINA)
    return sdf.format(this)
}

/**
 * 将时间段格式化指定格式，并已"-"分割
 * @param startDate
 * @param endDate
 * @param format
 * @return
 */
fun formatDurationDate(startDate: Date, endDate: Date, format: String): String {
    return formatDurationDate(startDate, endDate, format, " - ")
}

/**
 * 将时间段格式化成指定格式，并已指定字符进行分隔
 * @param startDate
 * @param endDate
 * @param format
 * @param separator
 * @return
 */
fun formatDurationDate(
    startDate: Date,
    endDate: Date,
    format: String,
    separator: String
): String {
    val sdf = SimpleDateFormat(format, Locale.CHINA)
    return sdf.format(startDate) + separator + sdf.format(endDate)
}

/**
 * 将时间段格式化指定格式，并已"-"分割
 * @param startTime
 * @param endTime
 * @param format
 * @return
 */
fun formatDurationDate(startTime: String, endTime: String, format: String): String {
    return formatDurationDate(startTime, endTime, format, " - ")
}

/**
 * 将时间段格式化指定格式，并以指定字符分割
 * @param startTime
 * @param endTime
 * @param format
 * @param separator
 * @return
 */
fun formatDurationDate(
    startTime: String,
    endTime: String,
    format: String,
    separator: String
): String {
    val sdf = SimpleDateFormat(format, Locale.CHINA)
    val startDate: Date = Date(startTime.toLong() * MILLI_SECOND_OF_SECOND)
    val endDate: Date = Date(endTime.toLong() * MILLI_SECOND_OF_SECOND)
    return sdf.format(startDate) + separator + sdf.format(endDate)
}

/**
 * 获取指定天的星期描述
 * @param weekDay
 * @return
 */
fun Int.getWeekText(): String {
    return if (this < 0 || this >= WEEKS.size) {
        ""
    } else "周" + WEEKS[this]
}

/**
 * 根据毫秒获取日期和星期
 * @param millisecond
 * @param pattern 日期的格式
 * @param prefix 星期的前缀，如周，星期等
 * @return
 */
fun Long.getDateAndWeek(pattern: String, prefix: String): String {
    val builder = StringBuilder()
    val sdf = SimpleDateFormat(pattern, Locale.CHINA)
    builder.append(sdf.format(Date(this)))
    val calendar = Calendar.getInstance()
    calendar.time = Date(this)
    builder.append(" ").append(prefix).append(WEEKS[calendar[Calendar.DAY_OF_WEEK] - 1])
    return builder.toString()
}

/**
 * 根据毫秒获取日期和星期
 * @param second
 * @param pattern 日期的格式
 * @param prefix  星期的前缀，如周，星期等
 * @return
 */
fun getDateAndWeek(second: String, pattern: String, prefix: String): String {
    return (second.toLong() * MILLI_SECOND_OF_SECOND).getDateAndWeek(
        pattern,
        prefix
    )
}

/**
 * 计算两个日期之间相差的天数
 * @param startDate
 * @param endDate
 * @return
 */
fun getDayCount(startDate: Date, endDate: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = startDate
    val startMilliSecond = calendar.timeInMillis
    calendar.time = endDate
    val endMilliSecond = calendar.timeInMillis
    return ((endMilliSecond - startMilliSecond) / MILLI_SECOND_OF_DAY).toInt()
}