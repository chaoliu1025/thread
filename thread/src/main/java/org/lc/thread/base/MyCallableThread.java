package org.lc.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyCallableThread<V> implements Callable<V>{
    private V resultsEntity;

    public MyCallableThread(V param) {
        this.resultsEntity = param;
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public V call() throws Exception {
        try {
            // 等待一段时间，模拟业务执行过程
            synchronized (this) {
                this.wait(5000);
            }
            // 设置返回结果
            ((Entity) this.resultsEntity).setStatus(1);
        } catch(Exception e) {
            // 执行错误了，也设置
            ((Entity) this.resultsEntity).setStatus(-1);
        }

        return this.resultsEntity;
    }

    public static void main(String[] args) throws Exception {
        //这是您定义的一个模型对象。里面有一个status属性
        MyCallableThread<Entity> callableThread = new MyCallableThread<Entity>(new Entity());

        // Callable需要在线程池中执行
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Entity> future = es.submit(callableThread);

        // main线程会在这里等待，知道callableThread任务执行完成
        Entity result = future.get();
        System.out.println("result.status = " + result.getStatus());
        // 停止线程池工作
        es.shutdown();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }
    
    private static class Entity{
    	private int status;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
    	
    	
    }


}
