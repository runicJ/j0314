package t4_Properties;

public class Test1 {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();  // 현재 돌아가는 스레드를 가져와라
		System.out.println("현재 스레드 이름 : " + thread.getName());
		System.out.println("현재 동작하는 스레드 수1 : " + Thread.activeCount());  // 클래스명으로 불러야함  // main 1개
		
		for(int i=0; i<3; i++) {
			Thread th = new Thread();
			System.out.println(th.getName());
			th.start();  // 내용이 없으니 생성되고 소멸 반복(같은 스레드 이름을 재사용x)
		}		
		System.out.println("현재 동작하는 스레드 수2 : " + Thread.activeCount());  // 모두 소멸되었다면 main 하나여야 하지만, 소멸 이전에 sysout이 count되어서 수가 다르게 나옴.
		System.out.println();
		
		for(int i=0; i<3; i++) {
			Thread th = new Thread();
			th.setName( i + "번째 스레드");
			System.out.println(th.getName());
			th.start();
		}		
		System.out.println("현재 동작하는 스레드 수2 : " + Thread.activeCount());
		System.out.println();
	}
}
