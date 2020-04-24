import java.util.LinkedList;
import java.util.Queue;

public class Order {

    private static final Integer FULL = 5;
    private static final Integer ORDERSUM = 1000;
    private static Integer unprocessedNumber = ORDERSUM;
	private static Integer orderNumber= 0;
    private static String LOCK = "lock";
    
    Queue<InnerOrder> queue = new LinkedList<>();
    
    public static void main(String[] args) {
    	
        Order test1 = new Order();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while(orderNumber <= ORDERSUM) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (queue.size() == FULL) {
                        try {
                        	System.out.println("we are waiting");
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (orderNumber <= ORDERSUM) {
                        orderNumber++;
                        queue.add(new InnerOrder(orderNumber));
                              
                    }
                    LOCK.notifyAll();    
                }
            }
        }
    }
    
    class Consumer implements Runnable {
        @Override
        public void run() {
            while(unprocessedNumber > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (queue.size() == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    
                    if (unprocessedNumber > 0) {
                    	
                    	unprocessedNumber--;
                    	queue.remove().process();
                        
                    }
                    LOCK.notifyAll();                	
                }
            }
        }
    }
    
    class InnerOrder {
    	private int orderNumber;
    	private String status;
    	
    	public InnerOrder(int n) {
    		this.orderNumber = n;
        	this.status = "new";
    	}
    	
    	public void process() {
    		status = "finished";
    		System.out.println("Processed Order Number: " + orderNumber);
    	}
    	
    	
    }
}
