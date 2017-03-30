package org.lc.thread.base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread<V> implements Callable<V>{
	
	
	private V entity;
	
	
	public CallableThread(Entity entity) {
		this.entity = (V) entity;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		FutureTask<Entity> futureTask =new FutureTask<Entity>(new CallableThread<Entity>(new Entity()));

		new Thread(futureTask).start();
		System.out.println(futureTask.get().getStatus());
		
	}

	@Override
	public V call() throws Exception {
		synchronized (this) {
			this.wait(5000);
		}
		((Entity) entity).setStatus(1);
		return entity;
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
