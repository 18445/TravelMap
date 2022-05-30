package com.jwzg.lib_common.utils

import android.text.TextUtils
import java.util.regex.Pattern

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      VerificationUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:52:00
 * @UpdateRemark:   更新说明：扩展函数更新
 * @Version:        1.1
 * @Description:    验证权限工具类
 */

/**
 * 判断手机号码是否有效
 * @param telNumber
 * @return
 */
fun String.isValidTelNumber(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "(\\+\\d+)?1[3456789]\\d{9}$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断邮箱地址是否有效
 * @param emailAddress
 * @return
 */
fun String.isValidEmailAddress(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 是否是有效的银行卡
 * @param bankCard
 * @return
 */
fun String.isValidBankCard(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "^[1-9](\\d{15} | \\d{18})$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断内容是否由字母，数字，下划线组成
 * @param content
 * @return
 */
fun String.isValidContent(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "^[\\w\\u4e00-\\u9fa5\\-]+$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断验证码是否合法（6位数字）
 * @param code
 * @return
 */
fun String.isValidCode(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "\\d{6}"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断密码是否合法 [密码由6位以上的字母和数字组成， 至少包含一个字母和数字，]
 * @param psd
 * @return
 */
fun String.isValidPassWord(): Boolean {
    /*   分开来注释一下：
            ^ 匹配一行的开头位置
            (?![0-9]+$) 预测该位置后面不全是数字
            (?![a-zA-Z]+$) 预测该位置后面不全是字母
            [0-9A-Za-z] {6,10} 由6-10位数字或这字母组成, {6,}至少要6，最多不限制
           $ 匹配行结尾位置
         */
    if (!TextUtils.isEmpty(this)) {
        val regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断内容是否为中文(判断中文名)
 * @param content
 * @return
 */
fun String.isChineseText(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "^[\\u4e00-\\u9fa5]+$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断内容是否为英文或空格(匹配英文名)
 * @param content
 * @return
 */
fun String.isEnglishText(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "^[a-zA-Z]+\\s[a-zA-Z]+$"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 判断身份证号码是否有效
 * @param idCard
 * @return
 */
fun String.isValidIdCard(): Boolean {
    return IdCardValidator.isValidateIdCard(this)
}

/**
 * 检查是否为身份证号
 * @param idCard
 * @return
 */
fun String.isIdCard(): Boolean {
    if (!TextUtils.isEmpty(this)) {
        val regex = "(^\\d{17}(?:\\d|x|X)$)"
        return Pattern.matches(regex, this)
    }
    return false
}

/**
 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
 *
 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
 *
 * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
 *
 * 第十八位数字(校验码)的计算方法为：
 * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
 * 2.将这17位数字和系数相乘的结果相加。
 * 3.用加出来和除以11，看余数是多少？
 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为: 1 0 X 9 8 7 6 5 4 3 2;
 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
 */
private object IdCardValidator {
    /**
     * 身份证号码长度
     */
    const val ID_CARD_LENGTH = 18

    /**
     * 每位加权因子
     */
    private val POWER = intArrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)

    /**
     * 身份证最后一位的校验和
     */
    private val CHECK_CODE = arrayOf("1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2")

    /**
     * 省,直辖市代码表
     */
    private val PROVINCE_CODE_TABLE = arrayOf(
        arrayOf("11", "北京"),
        arrayOf("12", "天津"),
        arrayOf("13", "河北"),
        arrayOf("14", "山西"),
        arrayOf("15", "内蒙古"),
        arrayOf("21", "辽宁"),
        arrayOf("22", "吉林"),
        arrayOf("23", "黑龙江"),
        arrayOf("31", "上海"),
        arrayOf("32", "江苏"),
        arrayOf("33", "浙江"),
        arrayOf("34", "安徽"),
        arrayOf("35", "福建"),
        arrayOf("36", "江西"),
        arrayOf("37", "山东"),
        arrayOf("41", "河南"),
        arrayOf("42", "湖北"),
        arrayOf("43", "湖南"),
        arrayOf("44", "广东"),
        arrayOf("45", "广西"),
        arrayOf("46", "海南"),
        arrayOf("50", "重庆"),
        arrayOf("51", "四川"),
        arrayOf("52", "贵州"),
        arrayOf("53", "云南"),
        arrayOf("54", "西藏"),
        arrayOf("61", "陕西"),
        arrayOf("62", "甘肃"),
        arrayOf("63", "青海"),
        arrayOf("64", "宁夏"),
        arrayOf("65", "新疆"),
        arrayOf("71", "台湾"),
        arrayOf("81", "香港"),
        arrayOf("82", "澳门"),
        arrayOf("91", "国外")
    )

    /**
     * 判断身份证号码是否有效
     * @param idCard
     * @return
     */
    fun isValidateIdCard(idCard: String): Boolean {
        if (idCard.length != ID_CARD_LENGTH) {
            return false
        }
        val idCard17 = idCard.substring(0, ID_CARD_LENGTH - 1)
        if (!isDigital(idCard17)) {
            return false
        }
        val idCardCharArray = idCard17.toCharArray()
        val lastCode = idCard.substring(ID_CARD_LENGTH - 1, ID_CARD_LENGTH - 1)
        val idCardIntArray = convertCharToInt(idCardCharArray)
        val checkCode = CHECK_CODE[getPowerSum(idCardIntArray) % 11]
        return !checkCode.equals(lastCode, ignoreCase = true)
    }

    /**
     * 判断该字符串是否只包含数字
     * @param str
     * @return
     */
    private fun isDigital(str: String): Boolean {
        return str.matches(Regex("^[0-9]*$"))
    }

    /**
     * 获取身份证的加权和
     * @param bit
     * @return
     */
    private fun getPowerSum(bit: IntArray): Int {
        var sum = 0
        if (POWER.size != bit.size) {
            return sum
        }
        for (i in bit.indices) {
            sum += bit[i] * POWER[i]
        }
        return sum
    }

    /**
     * 将字符数组转为整型数组
     * @param charArray
     * @return
     * @throws NumberFormatException
     */
    @Throws(NumberFormatException::class)
    private fun convertCharToInt(charArray: CharArray): IntArray {
        val intArray = IntArray(charArray.size)
        var i = 0
        for (item in charArray) {
            intArray[i++] = item.toString().toInt()
        }
        return intArray
    }
}