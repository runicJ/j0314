package t3_MultiThreadTest2;

class SMIFile extends Thread {  // 내부에서 쓸때는 public 쓰면 안됨
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

class ScreenFile extends Thread {
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

public class T2_ThreadRun {
	public static void main(String[] args) {  // main까지 3개의 스레드가 실행 중
		// 자막객체 생성 실행
		Thread smiThread = new SMIFile();
		smiThread.start();
		
		// 영상객체 생성 실행
		Thread scrThread = new ScreenFile();
		scrThread.start();
	}
}
