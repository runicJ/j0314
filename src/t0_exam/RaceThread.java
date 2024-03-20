package t0_exam;

import java.util.Scanner;

class Race implements Runnable {
  private int goal = 100;
  private int carNum;
  int cnt = 0;
  int tot = 0;

  public Race(int carNum) {
    this.carNum = carNum;
  }

  @Override
  public void run() {
    //String racing = "";
    StringBuffer racing = new StringBuffer();
    while (tot < goal) {
      if (tot < goal) {
        int trace = Math.min(goal-tot, (int)(Math.random()*8)+7);
        for (int j = 0; j < trace; j++) {
          //racing += "-";
        	racing.append("-");
        }
        tot += trace;
      }
      //racing += "*";
      racing.append("*");
      System.out.println("car" + carNum + " " + tot + "% => " + racing);
      if (tot >= goal) {
    		cnt++;
    		System.out.println("$$$$$ " + Thread.currentThread().getName() + " 도착");
    		System.out.println("$$$$$ " + Thread.currentThread().getName() + " 도착, "+cnt+"등입니다.");
      }
      try { Thread.sleep(500); } catch (InterruptedException e) {}
    }
  }
}

public class RaceThread {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("player를 선택하세요?( 1번차 | 2번차 | 3번차 | 4번차 | 5번차 ) ");
    String player = sc.next();
    System.out.println("===================== 경기 시작 =======================");

    Thread th1 = new Thread(new Race(1), "람보르기니");
    Thread th2 = new Thread(new Race(2), "마세라티");
    Thread th3 = new Thread(new Race(3), "포르쉐");
    Thread th4 = new Thread(new Race(4), "페라리");
    Thread th5 = new Thread(new Race(5), "부가티");

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
    System.out.println("===================== 경기 결과 =======================");
    System.out.println("선택하신 "+player+"번차는 " + "등 입니다.");
    sc.close();
  }
}