package com.jwzg.lib_common.utils

import android.content.Context
import android.os.Environment
import java.io.*
import java.util.*

/**
 *
 * @ProjectName:    TravelMap
 * @Package:        com.jwzg.lib_common.utils
 * @ClassName:      FileUtil
 * @Author:         Yan
 * @CreateDate:     2022年05月28日 22:47:00
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 * @Description:    文件操作的工具类
 */
/**
 * 默认的字符编码
 */
private const val DEFAULT_CHARSET_NAME = "UTF-8"

/**
 * SD卡是否有效
 * @return
 */
fun sdcardIsValid(): Boolean {
    return Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
}

/**
 * 文件是否存在
 * @param filePath
 * @return
 */
fun fileIsExist(filePath: String): Boolean {
    if (sdcardIsValid()) {
        val file = File(filePath)
        return file.exists()
    }
    return false
}

/**
 * 创建新的目录
 * @param path
 * @return
 */
fun mkdirs(path: String): Boolean {
    val file = File(path)
    return if (!file.exists()) {
        file.mkdirs()
    } else false
}

/**
 * 获取APP的缓存路径 data/data/包名/cache
 * @param context
 * @return
 */
fun getPrivatePath(context: Context): String {
    return context.cacheDir.absolutePath
}

/**
 * 保存文件到指定目录
 * @param directoryPath
 * @param fileName
 * @param content
 */
fun saveFile(directoryPath: String, fileName: String, content: String) {
    if (!sdcardIsValid()) {
        return
    }
    val directory = File(directoryPath)
    var directoryCreated = directory.exists()
    if (!directoryCreated) {
        directoryCreated = directory.mkdirs()
        if (!directoryCreated) {
            return
        }
    }
    val file = File(directoryPath, fileName)
    var outputStream: FileOutputStream? = null
    try {
        outputStream = FileOutputStream(file)
        outputStream.write(content.toByteArray(charset(DEFAULT_CHARSET_NAME)))
        outputStream.flush()
    } catch (e: Exception) {
        e.printStackTrace(System.out)
    } finally {
        if (outputStream != null) {
            try {
                outputStream.close()
            } catch (e: Exception) {
                e.printStackTrace(System.out)
            }
        }
    }
}

/**
 * 删除指定文件
 * @param directoryPath
 * @param fileName
 */
fun deleteFile(directoryPath: String, fileName: String) {
    deleteFile(directoryPath + File.separator + fileName)
}

/**
 * 删除指定文件
 * @param filePath
 */
fun deleteFile(filePath: String) {
    if (sdcardIsValid()) {
        return
    }
    val file = File(filePath)
    if (file.exists()) {
        file.delete()
    }
}

/**
 * 读取指定文件的内容
 * @param directoryPath
 * @param fileName
 * @return
 */
fun readFile(directoryPath: String, fileName: String): String? {
    return readFile(directoryPath + File.separator + fileName)
}

/**
 * 读取指定文件的内容
 * @param filePath
 * @return
 */
fun readFile(filePath: String): String? {
    if (!sdcardIsValid()) {
        return null
    }
    val file = File(filePath)
    if (!file.exists()) {
        return null
    }
    var inputStream: FileInputStream? = null
    try {
        inputStream = FileInputStream(file)
        val len = inputStream.available()
        val buffer = ByteArray(len)
        inputStream.read(buffer)
        inputStream.close()
        return Arrays.toString(buffer)
    } catch (e: Exception) {
        quietClose(inputStream)
    }
    return null
}

/**
 * 读取Asset中的文件
 * @param fileName
 * @return
 */
fun readAssetFile(context: Context, fileName: String): String? {
    var inputStream: InputStream? = null
    var reader: BufferedReader? = null
    try {
        inputStream = context.assets.open(fileName)
        reader = BufferedReader(InputStreamReader(inputStream, DEFAULT_CHARSET_NAME))
        var lineStr: String?
        val builder = StringBuilder()
        while (reader.readLine().also { lineStr = it } != null) {
            builder.append(lineStr)
        }
        inputStream.close()
        return builder.toString()
    } catch (e: Exception) {
        e.printStackTrace(System.out)
    } finally {
        quietClose(reader)
        quietClose(inputStream)
    }
    return null
}

/**
 * 获取指定文件的大小
 * @param directoryPath
 * @param fileName
 * @return
 */
fun getFileSize(directoryPath: String, fileName: String): Long {
    return getFileSize(directoryPath + File.separator + fileName)
}

/**
 * 获取指定文件的大小
 * @param filePath
 * @return
 */
fun getFileSize(filePath: String): Long {
    if (sdcardIsValid()) {
        val file = File(filePath)
        if (file.exists()) {
            return file.totalSpace
        }
    }
    return 0
}

fun quietClose(obj: Closeable?) {
    if (obj == null) {
        return
    }
    try {
        obj.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}