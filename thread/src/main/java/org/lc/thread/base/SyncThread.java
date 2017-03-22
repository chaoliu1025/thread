package org.lc.thread.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class SyncThread implements Runnable{
	
    /**
     * 日志
     */
    private static final Log LOGGER = LogFactory.getLog(SyncThread.class);

    private static  Integer value;

    private static Integer NOWVALUE;

    static {
        BasicConfigurator.configure();
    }

    public SyncThread(int value) {
        this.value = value;
    }

    /**
     * 对这个类的实例化对象进行检查
     */
    private synchronized void doOtherthing() {
        NOWVALUE = this.value;
        LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
    }
    
//    private  void doOtherthing() {
//    	synchronized (this) {
//    		NOWVALUE = value;
//    		LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//		}
//    }
    
//    private static synchronized void doOtherthing() {
//    	NOWVALUE = value;
//    	LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//    }
    
    
    
//    private void doOtherthing() {
//    	synchronized (SyncThread.class) {
//    		NOWVALUE = this.value;
//    		LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//		}
//    }
    

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        Long id = currentThread.getId();
        this.doOtherthing();
    }

    public static void main(String[] args) throws Exception {
//        Thread syncThread1 = new Thread(new SyncThread(10));
//        Thread syncThread2 = new Thread(new SyncThread(100));
//
//        syncThread1.start();
//        syncThread2.start();
    	SyncThread syncThread = new SyncThread(10);
        Thread syncThread1 = new Thread(syncThread);
        Thread syncThread2 = new Thread(syncThread);
        
        syncThread1.start();
        syncThread2.start();
    }


}
