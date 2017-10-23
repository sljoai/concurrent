package thread;

public class TestSynchronized {

	public static Object object = new Object();
	
	public static class T1 extends Thread{
		public void run() {
			System.out.println("T1 start!");
			synchronized (object) {
				try {
					object.wait();
					System.out.println("T1 wait!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("T1 end!");
		}
	}
	
	public static class T2 extends Thread{
		public void run() {
			System.out.println("T2 start!");
			synchronized (object) {
				object.notify();
				System.out.println("T2 notify!");
			}
			System.out.println("T2 end!");
		}
	}
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();
	}

}
