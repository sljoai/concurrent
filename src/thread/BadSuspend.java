package thread;

public class BadSuspend {

	public static Object u = new Object();
	public static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	public static ChangeObjectThread t2 = new ChangeObjectThread("t2");
	public static class ChangeObjectThread extends Thread{

		public ChangeObjectThread(String name) {
			super.setName(name);
		}
		@Override
		public void run() {
			synchronized (u) {
				System.out.println("in"+getName());
				Thread.currentThread().suspend();
			}
		}
		
	}
	public static void main(String[] args)  throws InterruptedException{
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.resume();
		t2.resume();//由于很有可能出现先调用resume，再去调用suspend，那么就会出现资源被冻住，可以通过jps查找线程号，再通过jstack查看线程状态
		t1.join();
		t2.join();
	}

}
