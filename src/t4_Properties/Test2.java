package t4_Properties;

class MyThread extends Thread {
	@Override
	public void run() {
		try { Thread.sleep(400); } catch (InterruptedException e) {}
		System.out.println(getName() + " 우선순위 : " + getPriority());  //getname 스레드 이름 
		System.out.println();
	}
}

// 멀티스레드는 원래 뭐가 먼저 실행될지 모름
// 스레드에 우선순위 지정: getPriority(), setPriority()
public class Test2 {
	public static void main(String[] args) {
		// 스레드 기본순위
		for(int i=0; i<3; i++) {
			System.out.println("메인스레드 " + i + ".번째 입니다.");
			Thread thread = new MyThread();
			thread.start();
		}
		
		// 스레드 우선순위 지정
		for(int i=0; i<10; i++) {  // 개수 안에서 순위 지정 가능  // 숫자가 클수록 순위가 높음
			Thread thread = new MyThread();
			thread.setName(i + "번째 스레드");
			if(i == 9) thread.setPriority(10);  // 11 주면 에러
			thread.start();
		}
	}
}
