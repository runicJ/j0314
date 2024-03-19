package t0_exam;

import java.util.Scanner;

class Race extends Thread {
	@Override
	public void run() {
		String tot = "";
		int per = 0;
		//System.out.println("경주 시작");
			for(int i=1; i<=5; i++) {
				for(int j=0; j<i; j++) {
					tot += "-";
					System.out.print(tot);
				}
				tot += "*";
				System.out.println(tot);
				for(int j=4; j>i; j--) {
					tot += ".";
					System.out.print(tot);
				}
			}
			try { Thread.sleep((int)(Math.random()*10)); } catch (InterruptedException e) {}
	}
}

public class RaceRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("plyer를 선택하세요?( 1 | 2 | 3 | 4 | 5 ) ");
//		String playerNum = "";
//		String select = sc.next();
				
		Race race = new Race();
		Thread th1 = new Thread(race, "1");
		Thread th2 = new Thread(race, "2");
		Thread th3 = new Thread(race, "3");
		Thread th4 = new Thread(race, "4");
		Thread th5 = new Thread(race, "5");
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.close();
	}	
}
