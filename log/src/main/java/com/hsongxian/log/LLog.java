package com.hsongxian.log;

import android.text.TextUtils;

import java.util.List;

public final class LLog {

    public static void init(String tag, Boolean debug) {
        TAG = tag;
        DEBUG = debug;
    }
    public static void init(String tag, Boolean dDebug, Boolean iDebug, Boolean eDebug) {
        TAG = tag;
        logEnabled_d = dDebug;
        logEnabled_i = iDebug;
        logEnabled_e = eDebug;
    }

    private static String TAG = "LLog";

    //    public static boolean debug = BuildConfig.DEBUG;
    private static boolean DEBUG = true;
    /**
     * Set true or false if you want read logs or not
     */
    private static boolean logEnabled_d = DEBUG;
    private static boolean logEnabled_i = DEBUG;
    private static boolean logEnabled_e = DEBUG;
    private static long currentTimeMillis;

    public static void d() {
        if (logEnabled_d) {
            android.util.Log.d(TAG, getLocation());
        }
    }

    public static String toString(Object o) {
        String text;
        if (o instanceof Class)
            text = ((Class) o).getSimpleName();
        else if (o instanceof List) {
            text = o.toString();
        } else {
            text = String.valueOf(o);
        }
        return text;
    }

    public static void d(Object msg) {
        if (logEnabled_d) {
            android.util.Log.d(TAG, getLocation() + toString(msg));
        }
    }

    public static void d(String TAG, String msg) {
        if (logEnabled_d) {
            android.util.Log.d(TAG, getLocation() + msg);
        }
    }

    public static void dTime(String msg) {
        if (logEnabled_d) {
            android.util.Log.d(TAG, "[Time:" + (System.currentTimeMillis() - currentTimeMillis) + "]" + getLocation() + msg);
            currentTimeMillis = System.currentTimeMillis();
        }
    }

    public static void dTime() {
        if (logEnabled_d) {
            android.util.Log.d(TAG, "[Time:" + (System.currentTimeMillis() - currentTimeMillis) + "]" + getLocation());
            currentTimeMillis = System.currentTimeMillis();
        }
    }


    public static void i(String msg) {
        if (logEnabled_i) {
            android.util.Log.i(TAG, getLocation() + msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (logEnabled_i) {
            android.util.Log.i(TAG, getLocation() + msg);
        }
    }

    public static void i() {
        if (logEnabled_i) {
            android.util.Log.i(TAG, getLocation());
        }
    }

    public static void e(String msg) {
        if (logEnabled_e) {
            android.util.Log.e(TAG, getLocation() + msg);
        }
    }


    public static void e(String msg, Throwable e) {
        if (logEnabled_e) {
            android.util.Log.e(TAG, getLocation() + msg, e);
        }
    }


    public static void e(String msg, String e) {
        if (logEnabled_e) {
            android.util.Log.e(TAG, getLocation() + msg + e);
        }
    }

    public static void e(Throwable e) {
        if (logEnabled_e) {
            android.util.Log.e(TAG, getLocation(), e);
        }
    }

    public static void e() {
        if (logEnabled_e) {
            android.util.Log.e(TAG, getLocation());
        }
    }

    private static String getLocation() {
        final String className = LLog.class.getName();
        final StackTraceElement[] traces = Thread.currentThread()
                .getStackTrace();

        boolean found = false;

        for (StackTraceElement trace : traces) {
            try {
                if (found) {
                    if (!trace.getClassName().startsWith(className)) {
                        Class<?> clazz = Class.forName(trace.getClassName());
                        return "[" + getClassName(clazz) + ":"
                                + trace.getMethodName() + ":"
                                + trace.getLineNumber() + "]: ";
                    }
                } else if (trace.getClassName().startsWith(className)) {
                    found = true;
                }
            } catch (ClassNotFoundException ignored) {
            }
        }

        return "[]: ";
    }

    private static String getClassName(Class<?> clazz) {
        if (clazz != null) {
            if (!TextUtils.isEmpty(clazz.getSimpleName())) {
                return clazz.getSimpleName();
            }

            return getClassName(clazz.getEnclosingClass());
        }

        return "";
    }

}
