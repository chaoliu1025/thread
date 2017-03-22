package org.lc.thread.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

public class MyDefindThread extends Thread{
	static {
        BasicConfigurator.configure();
    }

    /**
     * 日志。一定要使用Log4j才行。否则你就用System.out吧
     */
    private static final Log LOGGER= LogFactory.getLog(MyDefindThread.class);

    @Override
    public void run() {
        Long threadId =  this.getId();
        MyDefindThread.LOGGER.info("线程（" + threadId + "）做了一些事情，然后结束了。");
    }

    public static void main(String[] args) throws Exception {
        new MyDefindThread().start();
    }


}
