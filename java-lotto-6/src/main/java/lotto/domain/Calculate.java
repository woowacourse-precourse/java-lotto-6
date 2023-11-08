package lotto.domain;

import static lotto.domain.Rank.returnRank;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Rank.rank;

public class Calculate {
  public static double calculateReturnRate(List<Integer> statistics, int LottoPurchaseAmount) {
    double firstPrizeTotal = statistics.get(4) * rank.FIRST.prize;
    double secondPrizeTotal = statistics.get(3) * rank.SECOND.prize;
    double thirdPrizeTotal = statistics.get(2) * rank.THIRD.prize;
    double fourthPrizeTotal = statistics.get(1) * rank.FOURTH.prize;
    double fifthPrizeTotal = statistics.get(0) * rank.FIFTH.prize;
    double prizeTotal = firstPrizeTotal + secondPrizeTotal + thirdPrizeTotal + fourthPrizeTotal + fifthPrizeTotal;

    return Math.round(prizeTotal / LottoPurchaseAmount * 1000) / 10.0;

  }

  public static String printReturnValue(List<Integer> statistics, int LottoPurchaseAmount) {
    String result = ("총 수익률은 " + Calculate.calculateReturnRate(statistics, LottoPurchaseAmount) + "%입니다.");
    System.out.println(result);
    return result;
  }

  public static List<Integer> returnStatistics(Lotto[] randomNumbers, List<Integer> winNum, int bonusNum) {
    List<Integer> statistics = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    for (Lotto combination : randomNumbers) {
      int ranking = returnRank(winNum, combination, bonusNum); //등수반환
      if (ranking == 5) {
        statistics.set(0, statistics.get(0) + 1);
      }
      if (ranking == 4) {
        statistics.set(1, statistics.get(1) + 1);
      }
      if (ranking == 3) {
        statistics.set(2, statistics.get(2) + 1);
      }
      if (ranking == 2) {
        statistics.set(3, statistics.get(3) + 1);
      }
      if (ranking == 1) {
        statistics.set(4, statistics.get(4) + 1);
      }
    }
    return statistics;
  }

  public static int getMatchingNumber(List<Integer> winNum, Lotto oneCombination) {
    int matchinNumber = 0;

    for (Integer num : oneCombination.getNumbers()) {
      if (winNum.contains(num)) {
        matchinNumber++;
      }
    }
    return matchinNumber;
  }
}
