//package t0_exam;
//
//import java.util.Scanner;
//
//class Horse extends Thread {
//	String horseName = "";
//	int bat = 0, cnt = 0;
//	
//	int targetNum = 100;	// 전체 완주거리
//	int sum = 0;
//	String[] finalHorse = new String[5];
//	
//	public Horse(int bat, String horseName) {
//		this.bat = bat;
//		this.horseName = horseName;
//	}
//	
//	@Override
//	public void run() {
//		//StringBuffer sb = new StringBuffer();
//		String currentHorse = Thread.currentThread().getName();
//		
//		while(true) {
//			sum += (int)(Math.random()*10) + 1;
//			if(sum < targetNum) {
//				System.out.println(currentHorse + "완주율:" + sum + "% : " + ">".repeat(sum));
//			}
//			else {
//				sum = targetNum;
//				System.out.println(currentHorse + "완주율:" + sum + "% : " + ">".repeat(sum) + "("+currentHorse+"도착)");
//				finalHorse[cnt] = currentHorse;
//				cnt++;
//				break;
//			}
//		}
//		try { Thread.sleep(3000); } catch (InterruptedException e) {}
//	}
//
//	// 전체 순위와 배팅금액 계산하기
//	public void total() {
//		int baedangkum;
//		String horseRank;
//		
//		System.out.println("================== 결  과 =================");
//		for(int i=0; i<finalHorse.length; i++) {
//			System.out.println((i+1)+"등 : " + finalHorse[i]);
//		}
//
//		if(horseName.equals(finalHorse[0])) {
//			baedangkum = (int) (bat * 2.0);
//			horseRank = "1등";
//		}
//		else if(horseName.equals(finalHorse[1])) {
//			baedangkum = (int) (bat * 1.5);
//			horseRank = "2등";
//		}
//		else if(horseName.equals(finalHorse[2])) {
//			baedangkum = (int) (bat * 1.2);
//			horseRank = "3등";
//		}
//		else if(horseName.equals(finalHorse[3])) {
//			baedangkum = 0;
//			horseRank = "4등";
//		}
//		else {
//			baedangkum = 0;
//			horseRank = "5등";
//		}
//		
//		System.out.println();
//		System.out.println("=================================================");
//		System.out.println("당신이 배팅한 말 : " + horseName + " , 배팅한금액 : " + bat + " , 순위 : " + horseRank);
//		System.out.println("당첨금 : " + baedangkum + "원 입니다.");
//		System.out.println("=================================================");
//	}
//}
//
//public class RR {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String horseName = "";
//		int bat = 0;
//		// 일반스레드 5개
//		Horse horse = new Horse(bat, horseName);
//		Thread horse1 = new Thread(horse, "1번말(태양)");
//		Thread horse2 = new Thread(horse, "2번말(바람)");
//		Thread horse3 = new Thread(horse, "3번말(번개)");
//		Thread horse4 = new Thread(horse, "4번말(태권)");
//		Thread horse5 = new Thread(horse, "5번말(태풍)");
//		horse1.start();
//		horse2.start();
//		horse3.start();
//		horse4.start();
//		horse5.start();
//		
//		// main스레드가 모든 스레드가 종료될때까지 기다려준다.
//		try { 
//			horse1.join();
//			horse2.join();
//			horse3.join();
//			horse4.join();
//			horse5.join();
//		} catch (InterruptedException e) { 
//			e.printStackTrace();
//		}
//		horse.total();
//		
//		sc.close();
//	}
//}
