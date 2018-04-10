package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {	
	//
	private static final int QUEUE_SIZE = 10000;
	private static ArrayBlockingQueue<String> queue;
	static String MAX = "0";
	static List <String> sychedarrayList = Collections.synchronizedList(new ArrayList<String>());
	
	
	public static void main(String[] args) {		
		queue = new ArrayBlockingQueue<String>(100000);
		
		Producer producer = new Producer();
		Consumer consumer1 = new Consumer("consumer1");
		Consumer consumer2 = new Consumer("consumer2");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(producer);
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.shutdown();
	}
	private static ArrayBlockingQueue<String> getQueue() {
		return queue;
	}

	private static class Producer implements Runnable {
		private ArrayBlockingQueue<String> _queue;	
		public Producer() {			
			_queue = getQueue();						
		}
		
		@Override
		// Synchronize on the queue object.
		public synchronized void run() 
		{
			for (int i = 1; i < QUEUE_SIZE + 1 ; ++i) 
			{
				if (i%1000 == 0)
				{
					System.out.println("produced: " + i);
					String randomString = UUID.randomUUID().toString();
					try
					{			
						Thread.sleep(2);
						_queue.put(randomString);
					}
					catch (InterruptedException e) 
					{
							e.printStackTrace();
					}
				}
			}
			//print out the last produced.
			System.out.println("done producing! " + QUEUE_SIZE + " produced");
		}
	}
	
	private static class Consumer implements Runnable {
        private ArrayBlockingQueue<String> _queue;
		private final String  _name;
		public Consumer(String name) {
			_name = name;
			_queue = getQueue();						
		}
	
		@Override
		// Synchronize on the queue object.
		public synchronized void run() {
			for (int i = 1; i < (QUEUE_SIZE)/2 + 1 ; ++i) 
			{
				if (i%1000 == 0)
				{
					System.out.println(_name + " consumed: " + i);
					try
					{
						Thread.sleep(1);
						String string = _queue.take();
						if (string.compareTo(MAX) > 0) 
						{
							MAX = string;
						}						
					}
					catch (InterruptedException e) 
					{
						System.out.println("consumer ex");
					}

				}					
			}
			//print the last consumed and the biggest string. 
			System.out.println( _name + " done consuming! "+ (QUEUE_SIZE)/2 +" consumed");
			System.out.println( _name + " max String: " + MAX);
		}
	}
}
