package lotto;

import java.util.List;

public class Result {

  private final long total_price;
  private final long[] winningCounts = new long[6];
  private double total_rate = 0;

  public Result(long price) {
    total_price = price;
  }

  public void calculate(List<Double> counts) {
    for (Double count : counts) {
      Rank rank = Rank.valueOf(count);
      winningCounts[rank.ordinal()]++;
    }
    for(Rank rank : Rank.values()) {
      total_rate += rank.getPrizeMoney() * winningCounts[rank.ordinal()];
    }
    total_rate = total_rate / total_price * 100.0;
  }
  public void result() {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---");
    Rank[] ranks = Rank.values();
    for(int i = ranks.length - 1; i >= 0; i--) {
      Rank rank = ranks[i];
      if(rank != Rank.MISS) {
        String matchMessage = (int)rank.getMatchCount() + "개 일치";
        if(rank.getMatchCount() == 5.5) {
          matchMessage += ", 보너스 볼 일치";
        }
        System.out.println(matchMessage + " (" + rank.getPrizeMoneyString() + "원)" + " - " + winningCounts[rank.ordinal()] + "개");
      }
    }
    System.out.println("총 수익률은 " + total_rate + "%입니다.");
  }
}
