package t1_basicThread;

public class T2_MultiThread1Run {
	public static void main(String[] args) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("main(1). 현재 클래스명 : T2_MultiThread1Run");
		System.out.println("main(1). 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		
		T2_MultiThread1 t1 = new T2_MultiThread1();  // thread 상속받아 객체 생성 했기에 t1은 thread임 // Thread 상속받고 있는 겍체 생성
	  //t1.run();  // 스레드를 실행할때는 run()메소드가 아닌 start()메소드로 실행한다.
		t1.start();  // 작업이 먼저 끝나는 것이 먼저 실행 TSS(CPU 시간 쪼개서 나혼자 독점하듯이 사용)  // thread 2
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try {Thread.sleep(2000);} catch (InterruptedException e) {}  //2초 작업 지연
		System.out.println("main(2). 현재 클래스명 : T2_MultiThread1Run");
		System.out.println("main(2). 현재 실행중인 스레드 이름? " + Thread.currentThread().getName());
		System.out.println("main(2). "+Thread.currentThread().getName()+" 스레드가 종료되었습니다.");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
