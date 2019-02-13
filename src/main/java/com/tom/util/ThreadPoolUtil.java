package com.tom.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by DIY on 2017/5/11.
 */
public class ThreadPoolUtil {

    private static int corePoolSize = 50;
    private static int maximumPoolSize = 200 ;
//    public static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8000));
    public static ThreadPoolExecutor threadHaierPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(8000));

    public static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

//    public static ScheduledThreadPoolExecutor scheduledThreadPool1 = Executors.newScheduledThreadPool()

    public static void main(String[] args) throws InterruptedException {

        /*getThreadPoolInfo(threadPool);
        for (int i = 0; i < 20; i++) {
            Callable c = new TestCallable(i);
            threadPool.submit(c);
            getThreadPoolInfo(threadPool);
        }
        Thread.sleep(10000);
        getThreadPoolInfo(threadPool);*/


    }

    public static Map<String, Object> getThreadPoolInfo() {
        Map<String, Object> m1 = getThreadPoolInfo(threadPool);
        Map<String, Object> m2 = getThreadPoolInfo(threadHaierPool);

        Map<String, Object> all = new HashMap<>();
        all.put("threadPool", m1);
        all.put("threadHaierPool", m2);
        return all;
    }

    public static Map<String, Object> getThreadPoolInfo(ThreadPoolExecutor threadPool) {
        Map<String, Object> threadPoolMap = new HashMap<>();
        threadPoolMap.put("getPoolSize", threadPool.getPoolSize());
        threadPoolMap.put("getTaskCount", threadPool.getTaskCount());
        threadPoolMap.put("isShutdown", threadPool.isShutdown());
        threadPoolMap.put("getCorePoolSize", threadPool.getCorePoolSize());
        threadPoolMap.put("getMaximumPoolSize", threadPool.getMaximumPoolSize());
        threadPoolMap.put("getQueue_size", threadPool.getQueue().size());
        threadPoolMap.put("getActiveCount", threadPool.getActiveCount());
        threadPoolMap.put("getCompletedTaskCount", threadPool.getCompletedTaskCount());
        threadPoolMap.put("getLargestPoolSize", threadPool.getLargestPoolSize());
        System.out.println(JSON.toJSONString(threadPoolMap));
        return threadPoolMap;
    }


}
