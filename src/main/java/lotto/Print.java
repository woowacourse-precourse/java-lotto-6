package lotto;

import java.util.Map;

public class Print {
  public static void printStatistics(Map<Rank, Integer> rankCount, double returnRate) {
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5,000원) - " + rankCount.get(Rank.FIFTH) + "개");
    System.out.println("4개 일치 (50,000원) - " + rankCount.get(Rank.FORTH) + "개");
    System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(Rank.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(Rank.SECOND) + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(Rank.FIRST) + "개");
    System.out.println("총 수익률은 " + returnRate + "%입니다.");
  }
}
