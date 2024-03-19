package t1_basicThread;

// 스레드 만드는 방법1 : Thread 클래스를 상속
public class T2_MultiThread1 extends Thread {  // Thread 객체 상속(ctrl 클릭) override한 Run()메소드(747) override 안해도됨. 부모 것 뿐 아니라 조상 것도 override 가능
	@Override  // 강제 오버라이드 해야 가능
	public void run() {  // 이게 있어야 Thread 사용하려면 제어 가능
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. 현재 클래스명 : T2_MultiThread1");
		System.out.println("1. 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//for(int i=0; i<1000000000; i++) {}  // 쓸데없이 지연 방법1
		for(int i=1; i<=5; i++) {
			System.out.println("i = " + i);
			try {Thread.sleep(500);} catch (InterruptedException e) {} //   // 무조건 try, catch		
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("2. 현재 클래스명 : T2_MultiThread1");
		System.out.println("2. 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("2. " + Thread.currentThread().getName() + " 스레드가 종료됩니다.");	 
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
