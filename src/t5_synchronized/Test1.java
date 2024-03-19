package t5_synchronized;

// 일반 공유객체
class MyData {
	int data = 10;
	
	public void plusMothod() {
		int mydata = data;
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		data = mydata + 1;
	}
}

// 공유객체를 사용할 스레드 객체
class UseMyData extends Thread {
	MyData myData = new MyData();
//	public UseMyData() {}
//	public UseMyData(MyData myData) {
//		this.myData = myData;
//	}
	
	@Override
	public void run() {
		myData.plusMothod();
		System.out.println(getName() + "실행결과 : " + myData.data);
	}
}


public class Test1 {
	public static void main(String[] args) {
		// 공유객체를 각각 생성
		UseMyData useMyData = new UseMyData();
		// 스레드 동시 수행 둘다 10을 가져와서 1을 더함 누가 먼저하든 11이 덮어씀
		// #1 스레드
		Thread th1 = new UseMyData();
		th1.start();
		
		// #2 스레드
		Thread th2 = new UseMyData();
		th2.start();
		
	}
}