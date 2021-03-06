package org.springframework.samples.mvc.ext;


import java.util.Stack;

/**
 * 秒表,用于计时,一般用于调试性能
 *
 * @author Administrator
 *
 */
public class StopWatch {

    private Stack<Long> timeStack = new Stack<Long>();
    private long lastTime = 0;

    private static ThreadLocal<StopWatch> threadLocal = new ThreadLocal<StopWatch>() {
        protected synchronized StopWatch initialValue() {
            return new StopWatch();
        }
    };

    /**
     * 获取秒表实例
     *
     * @return StopWatch
     */
    public static StopWatch get() {
        return threadLocal.get();
    }

    /**
     * 开始计时
     *
     * @return 开始时间
     */
    public void start() {
        long start = System.currentTimeMillis();
        timeStack.push(start);
    }

    /**
     * 结束计时
     *
     * @return 结束时间
     */
    public long stop() {
        long end = System.currentTimeMillis();
        if (!timeStack.empty()) {
            long startTime = timeStack.pop();
            lastTime = end - startTime;
        }
        return lastTime;
    }

    /**
     * 返回最后一次计时时间
     *
     * @return 毫秒
     */
    public long time() {
        return lastTime;
    }

    /**
     * 当前秒表是否正在计时?
     *
     * @return true: 正在计时, false 没有计时
     */
    public boolean running() {
        return !timeStack.empty();
    }

    /**
     * 清除所有正在计时的项目
     */
    public void clear() {
        timeStack.clear();
    }
}
