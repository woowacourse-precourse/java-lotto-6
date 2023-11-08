package lotto;

import java.util.List;

public class Result {

  private final int total_price;
  private int fifth_winning = 0;
  private int fourth_winning = 0;
  private int third_winning = 0;
  private int second_winning = 0;
  private int first_winning = 0;
  private double total_rate = 0;

  public Result(int price) {
    total_price = price;
  }

  public void calculate(List<Double> count) {

    for (Double v : count) {
      if(v == 3 || v == 3.5) fifth_winning++;
      else if(v == 4 || v == 4.5) fourth_winning++;
      else if(v == 5) third_winning++;
      else if(v == 5.5) second_winning++;
      else if(v == 6 || v == 6.5) first_winning++;
    }

    total_rate = (double) (fifth_winning*5000
            + fourth_winning*50000
            + third_winning*1500000
            + second_winning*30000000
            + first_winning*2000000000) / total_price ;
  }
  public void result() {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5000원) - " + fifth_winning + "개");
    System.out.println("4개 일치 (50,000원) - " + fourth_winning + "개");
    System.out.println("5개 일치 (1,500,000원) - " + third_winning + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second_winning + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + first_winning + "개");
    System.out.println("총 수익률은 " + total_rate + "% 입니다.");
  }
}
