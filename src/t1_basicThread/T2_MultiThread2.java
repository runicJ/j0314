package t1_basicThread;

// 스레드 만드는 방법2 : Runnable 인터페이스를 구현하는 구현객체를 만든 후 스레드 생성시 매개변수로 처리해준다.
public class T2_MultiThread2 implements Runnable {  // Thread Runnable 인터페이스 // 오버라이드 안하면 에러가 나기 때문에 이클립스에서 만들라고 함.
// thread 클래스를 써야 스레드, 단지 Runnable이라는 구현객체 run()으로 동작만 만든것
	@Override
	public void run() {  // 이게 있어야 Thread 사용하려면 제어 가능
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. 현재 클래스명 : T2_MultiThread2");
		System.out.println("1. 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//for(int i=0; i<1000000000; i++) {}  // 쓸데없이 지연 방법1
		for(int i=1; i<=5; i++) {
			System.out.println("i = " + i);
			try {Thread.sleep(500);} catch (InterruptedException e) {} //   // 무조건 try, catch		
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("2. 현재 클래스명 : T2_MultiThread2");
		System.out.println("2. 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("2. " + Thread.currentThread().getName() + " 스레드가 종료됩니다.");	 
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
