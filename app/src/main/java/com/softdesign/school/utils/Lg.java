package com.softdesign.school.utils;

import android.util.Log;

/**
 * Created by Rodnoy on 29.01.2016.
 */
public class Lg {

    /**
     * Префикс сообщений
     */
    private static final String PREFIX = "SCHOOL DESIGN ";
    /**
     * Максимальная длина сообщения
     *     public static final int LOGCAT_BUFFER_SIZE = 3000;
     */


    /**
     * Включает логер
     */
    private static boolean shouldLog() {
        return true;
    }
    /**
     * levelLog - целое значение, соответствует константе уровня из android.util.Log;
     * place - наименование компонента, который вызвал данный метод
     * msgtxt - текст сообщения в логе
     */
    public static void msgLog(int levelLog, String place, String msgTxt) {
        if (shouldLog()) {

            switch (levelLog) {
                case Log.VERBOSE:
                    Log.v(PREFIX + place, msgTxt);
                    break;
                case Log.DEBUG:
                    Log.d(PREFIX + place, msgTxt);
                    break;
                case Log.INFO:
                    Log.i(PREFIX + place, msgTxt);
                    break;
                case Log.WARN:
                    Log.w(PREFIX + place, msgTxt);
                    break;
                case Log.ERROR:
                    Log.e(PREFIX + place, msgTxt);
                    break;
                case Log.ASSERT:
                    Log.println(Log.ASSERT, PREFIX + place, msgTxt);
                    break;
            }

        }
    }
}
