package com.akakim.lib

import java.io.*

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-02-07
 */

open class StringUtil{
    companion object{

        fun readInputStreamToString(stream: InputStream) : String{
            val writer: Writer = StringWriter()
            val buffer = CharArray(1024)

            try {
                val reader: Reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
                var n: Int = 0
                while (reader.read(buffer).also({ n = it }) != -1) {
                    writer.write(buffer, 0, n)
                }
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                //    if ( inputStream != null)
                stream.close()
            }
            return writer.toString()
        }
    }
}