
package com.cjj.sva.utils;

import android.util.Log;

/**
 * 这是一个神奇的类，神奇就是它可以打log,而你，不可以打我！
 *
 */
public final class LogHelper {
    public static final boolean mIsDebugMode = true;// 获取堆栈信息会影响性能，发布应用时记得关闭DebugMode
    private static final String TAG = "JJSearchView";

    private static final String CLASS_METHOD_LINE_FORMAT = "%s.%s()_%s";

    public static void trace(String str) {
        if (mIsDebugMode) {
            StackTraceElement traceElement = Thread.currentThread()
                    .getStackTrace()[3];// 从堆栈信息中获取当前被调用的方法信息
            String className = traceElement.getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            String logText = String.format(CLASS_METHOD_LINE_FORMAT,
                    className,
                    traceElement.getMethodName(),
                    String.valueOf(traceElement.getLineNumber()));
            Log.i(TAG, logText + "->" + str);// 打印Log
        }
    }

    public static void printStackTrace(Throwable throwable) {
        if (mIsDebugMode) {
            Log.w(TAG, "", throwable);
        }
    }
}
