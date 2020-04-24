
public class Order {
	private static Integer count = 0;
    private static final Integer FULL = 5;
    private static Integer sum = 100;
    private static String LOCK = "lock";
    
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
            while(sum > 0) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                        	System.out.println("we are waiting");
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (sum < 0)
                    	break;
                    count++;
                    System.out.println(Thread.currentThread().getName() + " producer count: " + count);
                    System.out.println(Thread.currentThread().getName() + " remaining order: " + sum);
                    LOCK.notifyAll();
                    
                }
            }
        }
    }
    
    class Consumer implements Runnable {
        @Override
        public void run() {
            while(sum > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
             
                    if (sum < 0)
                    	break;
              
                	count--;
                	sum--;
                    System.out.println(Thread.currentThread().getName() + " consumer count: " + count);
                    System.out.println(Thread.currentThread().getName() + " sold order: " + (100 - sum));
                    LOCK.notifyAll();
                }
            }
        }
    }
}
