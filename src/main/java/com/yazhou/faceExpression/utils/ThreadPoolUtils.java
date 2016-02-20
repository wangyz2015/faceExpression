package com.yazhou.faceExpression.utils;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangyazhou on 16/1/10.
 */
public class ThreadPoolUtils {
    private static final ScheduledThreadPoolExecutor SCHEDULED_THREAD_POOL_EXECUTOR = new ScheduledThreadPoolExecutor(50);


    public static void scheduleAtFix(Runnable r, long delay, long interval) {
        SCHEDULED_THREAD_POOL_EXECUTOR.scheduleAtFixedRate(r, delay, interval, TimeUnit.SECONDS);
    }
}
