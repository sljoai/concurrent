package synchronize;

public class SynchronizedTest {

	public static void main(String[] args) {

		final Test test = new Test();
		
//		ThreadInstance instance1 = new ThreadInstance(test);
//		
//		ThreadInstance instance2 = new ThreadInstance(test);
//		
//		instance1.start();
//		instance2.start();
//		
//		instance1.printTest();
//		instance2.printTest();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				test.test1();
//				synchronized(test){
//					test.test1();
//				};
//				
			}
			
		}).start();
		
		new Thread(new Runnable(){
			public void run(){
//				test.print();
				test.test1();
//				synchronized(test){
//					test.print();
//				};
//				test.print();
//				test.test1();
			}
		}).start();
	}
	
	

}

//class ThreadInstance extends Thread{
//
//	private Test test;
//	@Override
//	public void run() {
//		
//		
//	}
//	
//	public ThreadInstance(Test test){
//		this.test=test;
//	}
//	
//	public void printTest(){
//		
//		System.out.println("-----------");
//		test.test1();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//}

class Test{
	
	public void print(){
//	public synchronized void print(){
		System.out.println("-----------");
		System.out.println(Thread.currentThread().getName()+"\tprint:");
		
	}
	
//	public void test1(){
	public synchronized void test1(){
		System.out.println("-----------");
		System.out.println(Thread.currentThread().getName()+"\ttest1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}