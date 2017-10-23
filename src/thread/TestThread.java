package thread;

public class TestThread {

	public static void main(String[] args) {
		TestThread test =  new TestThread();
		MultiThread t= test.new MultiThread();
		Thread t1 = new Thread(t);
		t1.start();
		for(int i=0;i<5;i++){
			new Thread(t).start();
		}
		t1.stop();
		//System.exit(0);
	}
	
	public class MultiThread implements Runnable{
		
		private int a=0;
		@Override
		public void run() {
			synchronized(""){
				a++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				a--;
				System.out.println(a);
			}
		}
		
	}

}
