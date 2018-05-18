package org.lc.thread.base;


public class SyncThread implements Runnable{
	

    private Integer value;

    private static Integer NOWVALUE;


    public SyncThread(int value) {
        this.value = value;
    }

    /**
     * 对这个类的实例化对象进行检查
     */
//    private synchronized void doOtherthing() {
//        NOWVALUE = this.value;
//        LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//    }
    
    private  void doOtherthing() {
    	synchronized (String.class) {
    		NOWVALUE = value;
    		System.out.println("当前NOWVALUE的值：" + NOWVALUE);
		}
    }
    
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
        Thread syncThread1 = new Thread(new SyncThread(10));
        Thread syncThread2 = new Thread(new SyncThread1(100));

        syncThread1.start();
        syncThread2.start();
//    	SyncThread syncThread = new SyncThread(10);
//        Thread syncThread1 = new Thread(syncThread);
//        Thread syncThread2 = new Thread(syncThread);
//        
//        syncThread1.start();
//        syncThread2.start();
    }
    
    


}

 class SyncThread1 implements Runnable{
	

    private static  Integer value;

    private static Integer NOWVALUE;


    public SyncThread1(int value) {
        this.value = value;
    }

    /**
     * 对这个类的实例化对象进行检查
     */
//    private synchronized void doOtherthing1() {
//        NOWVALUE = this.value;
//        LOGGER.info("当前NOWVALUE的值：" + NOWVALUE);
//    }
    
    private  void doOtherthing1() {
    	synchronized (String.class) {
    		NOWVALUE = value;
    		System.out.println("当前NOWVALUE的值：" + NOWVALUE);
		}
    }
    
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
        this.doOtherthing1();
    }
  }
