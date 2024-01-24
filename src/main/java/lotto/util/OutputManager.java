package lotto.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningCheck;

public class OutputManager {

  public static void printGeneratedLottoNumbers(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      List<Integer> sortedLottoNumbers = new ArrayList<>(lotto.getLottoNumbers());
      Collections.sort(sortedLottoNumbers);
      System.out.println(sortedLottoNumbers);
    }
  }

  public void printResults(Map<WinningCheck, Integer> result, double profitRate) {
    printWinningResult(result);
    printProfitRate(profitRate);
  }

  private void printWinningResult(Map<WinningCheck, Integer> result) {
    DecimalFormat decimalFormat = new DecimalFormat("#,###");
    System.out.println("\n당첨 통계\n---");
    for (WinningCheck prize : WinningCheck.values()) {
      if (prize == WinningCheck.LOSE) {
        continue;
      }
      String bonus = prize.hasBonus() ? ", 보너스 볼 일치" : "";
      String formattedPrize = decimalFormat.format(prize.getPrizeAmount());
      System.out.println(
          prize.getMatchingCount() + "개 일치" + bonus + " (" + formattedPrize + "원) - "
              + result.getOrDefault(prize, 0) + "개");
    }
  }

  private void printProfitRate(double profitRate) {
    System.out.println("총 수익률은 " + profitRate + "%입니다.");
  }
}
