package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.LottoRank.*;

public class ResultView {
  private static String calculateProfitRate(Map<LottoRank, Integer> result) {
    int totalPrizeMoney = result.entrySet().stream()
        .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
        .sum();
    
    int purchaseAmount = result.values().stream().mapToInt(Integer::intValue).sum() * 1000;
    
    double profitRate = (double) totalPrizeMoney / purchaseAmount * 100;
    
    DecimalFormat df = new DecimalFormat("0.#");
    return df.format(profitRate);
  }
  
  public void printLottos(List<Lotto> lottos) {
    System.out.println(lottos.size() + "개를 구매했습니다.");
    for (Lotto lotto : lottos) {
      System.out.println(lotto);
    }
  }
  
  public void printResult(Map<LottoRank, Integer> result) {
    System.out.println("당첨 통계");
    System.out.println("---");
    
    printRankResult(FIFTH, result);
    printRankResult(FOURTH, result);
    printRankResult(THIRD, result);
    printRankResult(SECOND, result);
    printRankResult(FIRST, result);
    
    String profitRate = calculateProfitRate(result);
    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }
  
  private static void printRankResult(LottoRank rank, Map<LottoRank, Integer> result) {
    System.out.println(rank.getCountOfMatch()
        + "개 일치"
        + (rank == SECOND ? ", 보너스 볼 일치 " : " ")
        + "(" + String.format("%,d", rank.getWinningMoney()) + "원) - "
        + result.getOrDefault(rank, 0) + "개");
  }
}
