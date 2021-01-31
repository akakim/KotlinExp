package com.akakim.kotlinlib.util

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-30
 */
open class  DLog {
    /**
     * 디버깅을 할 때
     * 어느 시점에서 에러가났는지를 확인할 수 있게
     * 설정한 태그임.
     */

    companion object{

        var CONTEXT_TAG = "Default"
        const val INIT_TAG = "Default"
        lateinit var context: Context
        private var isDebuggable = false
        fun init(context: Context) {
            Companion.context = context
            isDebuggable =
                isDebuggable()
            isDebuggable = true
        }

        fun setContextTag(tag: String) {
            CONTEXT_TAG = tag
        }

        fun initContextTag() {
            CONTEXT_TAG =
                INIT_TAG
        }

        /** Log Level Error  */
        fun e(message: String) {
            if (isDebuggable) Log.d(
                CONTEXT_TAG, message)
        }

        /** Log Level Warning  */
        fun w(message: String) {
            if (isDebuggable) android.util.Log.d(
                CONTEXT_TAG, message)
        }

        /** Log Level Information  */
        fun i(message: String) {
            if (isDebuggable) android.util.Log.i(
                CONTEXT_TAG,
                buildLogMsg(message)
            )
        }

        /** Log Level Debug  */
        fun d(message: String?) {
            if (isDebuggable) android.util.Log.d(
                CONTEXT_TAG,
                buildLogMsg(message)
            )
        }

        /** Log Level Verbose  */
        fun v(message: String?) {
            if (isDebuggable) android.util.Log.v(
                CONTEXT_TAG,
                buildLogMsg(message)
            )
        }

        fun buildLogMsg(message: String?): String {
            val ste =
                Thread.currentThread().stackTrace[4]
            val sb = StringBuilder()
            sb.append("[")
            sb.append(ste.fileName.replace(".java", ""))
            sb.append("::")
            sb.append(ste.methodName)
            sb.append("]")
            sb.append(message)
            return sb.toString()
        }

        /**
         * BuildConfig.DEBUG로 디버그 모드를 알 수  있는건
         *
         * @return
         */
        private fun isDebuggable(): Boolean {
            var debuggable = false
            val pm: PackageManager = context.getPackageManager()
            try {
                val appinfo: ApplicationInfo = pm.getApplicationInfo(context.getPackageName(), 0)
                DLoggingInfo("app info Flag " + appinfo.flags)
                DLoggingInfo("app Info Debuggable " + ApplicationInfo.FLAG_DEBUGGABLE)
                DLoggingInfo("app Info and operation" + (0 != appinfo.flags and ApplicationInfo.FLAG_DEBUGGABLE))
                debuggable = 0 == appinfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
            } catch (e: android.content.pm.PackageManager.NameNotFoundException) {
                /* debuggable variable will remain false */
                isDebuggable = false
            }
            if (isDebuggable) {
                DLoggingInfo("is Logging on")
            } else {
                DLoggingInfo("is Logging on")
            }
            return debuggable
        }

        private fun DLoggingInfo(message: String) {
            android.util.Log.i(DLog::class.java.simpleName, message)
        }
    }

}
