package t1_basicThread;

public class T1_SingleThread {
	public static void main(String[] args) {
		System.out.println("모든 실행클래스는 main스레드 1개를 가진다.");
		System.out.println("현재 스레드 명 : " + Thread.currentThread().getName());  // 전부 static thread.sleep 사용해봄(예외처리)  // 이름을 따로주지 않아도 main
	}
}
