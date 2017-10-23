package thread;

public class VisibilityTest extends Thread{

	public static void main(String[] args) throws InterruptedException{
		VisibilityTest test = new VisibilityTest();
		test.start();
		Thread.sleep(1000);
		test.setStop();
		Thread.sleep(2000);
		System.out.println("finish main!");
		System.out.println(test.getStop());
		
	}

//	private volatile boolean stop=false;//当添加volatile时，线程会退出，并且会打印i的值

	private  boolean stop=false;//虽然修改了stop的值，但是线程未跳出循环。
	
	
	@Override
	public void run() {
		int i=0;
		while(!stop) {
			i++;
		}
		System.out.println(i);
	}
	
	public void setStop() {
		this.stop=true;
	}
	 
	public boolean getStop() {
		return stop;
	}

}
