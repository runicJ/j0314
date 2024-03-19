package t3_MultiThreadTest2;
/*
class SMIFile2 implements Runnable {
	@Override
	public void run() {
		// #2. 자막
		String[] smiArray = {"하나","둘","셋","넷","다섯"};
		try { Thread.sleep(10); } catch (InterruptedException e) {}
		
		// #4. 자막출력
		for(int i=0; i<smiArray.length; i++) {
			System.out.println("- 자막 : " + smiArray[i]);
			try { Thread.sleep(500); } catch (InterruptedException e) {}
		}
	}
}

class ScreenFile2 implements Runnable {
	@Override
	public void run() {
		// #1. 영상프레임 1~5컷
		int[] screensArray = {1,2,3,4,5};
		
		// #3. 영상출력
		for(int i=0; i<screensArray.length; i++) {
			System.out.print("영상프레임 : " + screensArray[i]);
			try { Thread.sleep(500); } catch (InterruptedException e) {}
		}
	}
}
*/
public class T4_ThreadRun {
	public static void main(String[] args) {  // main(th1,th2를 동작하기 위해 필요) th1 th2 (독립적으로) 3개 스레드 실행
		// 자막을 출력하는 스레드를 익명이너클래스로 구현한다.  // 인터페이스, 추상클래스 독립적 생성 원래 불가
		//Thread th1 = new Thread() {};
		Thread th1 = new Thread(new Runnable() {  // 필드 선언하면서 익명 이너클래스 {} 실행블록 뒤에 붙임
			@Override
			public void run() {
				// #2. 자막
				String[] smiArray = {"하나","둘","셋","넷","다섯"};
				try { Thread.sleep(10); } catch (InterruptedException e) {}  // 영상과 자막 중 누가 먼저 나올지 몰라서
				
				// #4. 자막출력
				for(int i=0; i<smiArray.length; i++) {
					System.out.println("- 자막 : " + smiArray[i]);
					try { Thread.sleep(500); } catch (InterruptedException e) {}
				}
			}
		});
		
		// 영상을 출력하는 스레드를 익명클래스로 구현한다.
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// #1. 영상프레임 1~5컷
				int[] screensArray = {1,2,3,4,5};
				
				// #3. 영상출력
				for(int i=0; i<screensArray.length; i++) {
					System.out.print("영상프레임 : " + screensArray[i]);
					try { Thread.sleep(500); } catch (InterruptedException e) {}
				}
			}
		});
		
		th1.start();
		th2.start();
	}
}
