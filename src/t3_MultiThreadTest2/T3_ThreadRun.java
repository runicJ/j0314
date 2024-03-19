package t3_MultiThreadTest2;

class SMIFile2 implements Runnable {  // 하나의 패키지 안에 같은 클래스 파일명 있음x
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

class ScreenFile2 implements Runnable {  // runnable 상속받는 것과 같음
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

public class T3_ThreadRun {
	public static void main(String[] args) {  // main까지 3개의 스레드가 실행 중
		// 자막객체 생성 실행
		Runnable smiThread = new SMIFile2();  // 인터페이스 객체로 가능
		Thread th1 = new Thread(smiThread);
		th1.start();
		
		// 영상객체 생성 실행
		Runnable scrThread = new ScreenFile2();
		Thread th2 = new Thread(scrThread);
		th2.start();
	}
}
