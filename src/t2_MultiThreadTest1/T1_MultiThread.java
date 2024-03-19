package t2_MultiThreadTest1;

public class T1_MultiThread extends Thread {
	int cnt = 0;
	
	@Override
	public void run() {  // run()메소드로 동작할 내용을 넣어줌
		for(int i=1; i<=10; i++) {
			if(Thread.currentThread().getName().equals("mbc")) {
				System.out.println("cnt : " + cnt);
				cnt++;
			}
			System.out.println(i + "스레드명 : " + Thread.currentThread().getName());
			try { Thread.sleep(500); } catch (InterruptedException e) {}  // 스레드 지연			
		}
		
	}
}
