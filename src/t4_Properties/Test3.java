package t4_Properties;

// 메인스레드가 끝나도 일반스레드의 작업이 끝나지 않으면 JVM은 작업을 끝내지 않는다.(기본)
// 일반스레드를 메인스레드에 종속되도록 처리하려면 데몬스레드를 이용한다.
// 일반스레드:setDaemon(false), 데몬스레드:setDaemon(true)

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println(getName() + " : " + (isDaemon() ? "데몬스레드" : "일반스레드"));  // is 붙이면 묻는것  //2
		for(int i=1; i<=5; i++) {
			System.out.println(getName() + " : " + i + "초");  // 5초  // 3  // 5
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
		}
	}
}

public class Test3 {
	public static void main(String[] args) {
		// 일반스레드
		Thread thread = new MyThread2();
		thread.setDaemon(false);  // false : 일반스레드
		thread.setName("thread1");
		thread.start();  // 끝나면 main 끝  //1
		
		// 메인스레드를 3초간 지연처리 후 종료시켜준다.
		try { Thread.sleep(3000); } catch (InterruptedException e) {}  // 4
		System.out.println("main 스레드 종료");
	}
}
