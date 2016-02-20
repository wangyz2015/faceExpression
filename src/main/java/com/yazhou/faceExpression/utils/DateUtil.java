package com.yazhou.faceExpression.utils;

import java.util.Date;

/**
 * Created by wangyazhou on 16/2/20.
 */
public class DateUtil {
    public static long getNextNDay(long dayOff) {
        Date expectDate = new Date();
        expectDate.setHours(0);
        expectDate.setMinutes(0);
        expectDate.setSeconds(0);
        expectDate.setDate(expectDate.getDate() + (int)dayOff);
        return expectDate.getTime();
    }
}
