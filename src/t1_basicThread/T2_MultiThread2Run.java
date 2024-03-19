package t1_basicThread;

public class T2_MultiThread2Run {
	public static void main(String[] args) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("main(1). 현재 클래스명 : T2_MultiThread2Run");
		System.out.println("main(1). 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		
		T2_MultiThread2 t2 = new T2_MultiThread2();  // thread 객체가 아님  스레드 대입해서 만들어야 함
		//Thread thread = new Thread(t2);  // thread에 매개변수로 넣어서 스레드로 만듬.
		Thread thread = new Thread(t2, "atom");  // 스레드 생성할때 이름 지정
	  //t1.run();
		thread.start();
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try {Thread.sleep(2000);} catch (InterruptedException e) {}  //2초 작업 지연
		System.out.println("main(2). 현재 클래스명 : T2_MultiThread2Run");
		System.out.println("main(2). 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("main(2). "+Thread.currentThread().getName()+" 스레드가 종료되었습니다.");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
