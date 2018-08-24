package org.lc.thread.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class TestCyclicBarrier {
	
	static {
        BasicConfigurator.configure();
    }

    /**
     * 日志
     */
    private static Log LOGGER = LogFactory.getLog(TestCyclicBarrier.class);

    public static void main(String[] args) throws Throwable {
        // 同步计数器的技术周期为3
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        // 启动子线程，处理“其他”业务
        for(int index = 0 ; index < 5 ; index++) {
            Thread childThread = new Thread() {
                @Override
                public void run() {
                    // 可获得设置的屏障数值
                    // int parties = cyclicBarrier.getParties();
                    // 可获取当前已经进入等待状态的任务数量
                    // int numberWaiting = cyclicBarrier.getNumberWaiting();
                    TestCyclicBarrier.LOGGER.info("本线程已准备好处理业务......");
                    try {
						cyclicBarrier.await();
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
                    TestCyclicBarrier.LOGGER.info("开始处理业务......");
                }
            };
            childThread.start();
        }
    }

}
