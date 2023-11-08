package lotto;

public class Result {
  int fifth_winning = 0;
  int fourth_winning = 0;
  int third_winning = 0;
  int second_winning = 0;
  int first_winning = 0;
  double total_rate = 0;

  public void calculate(int count) {
    if(count == 3) fifth_winning++;
    else if(count == 4) fourth_winning++;
    else if(count == 5) third_winning++;
    else if(count == 5 || ) second_winning++;
    else if(count == 6) first_winning++;
  }
  public void result() {
    System.out.println("3개 일치 (5000원) - " + fifth_winning + "개");
    System.out.println("4개 일치 (50,000원) - " + fourth_winning + "개");
    System.out.println("5개 일치 (1,500,000원) - " + third_winning + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second_winning + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + first_winning + "개");
    System.out.println("총 수익률은 " + total_rate + "입니다.");
  }
}
