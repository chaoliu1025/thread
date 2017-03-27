package org.lc.thread.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class Join2Thread implements Runnable{
    static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static Log LOGGER = LogFactory.getLog(Join2Thread.class);

    public static void main(String[] args) throws Exception {
        Thread joinThread1 = new Thread(new Join2Thread());
        joinThread1.start();
        Thread joinThread2 = new Thread(new Join2Thread());
        joinThread2.start();
    }

    @Override
    public void run() {
        // 使用sleep方法，模型这个线程执行业务代码的过程
        try {
            synchronized (Join2Thread.class) {
                Thread.sleep(Long.MAX_VALUE);
            }
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


}
