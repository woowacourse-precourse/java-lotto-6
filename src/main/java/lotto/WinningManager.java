package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningManager {
  private final List<StatisticsComment> WINNING_STATISTICS_COMMENT = new ArrayList<>(
    List.of(
        StatisticsComment.THREE_MATCHES,
        StatisticsComment.FOUR_MATCHES,
        StatisticsComment.FIVE_MATCHES,
        StatisticsComment.FIVE_MATCHES_BONUS,
        StatisticsComment.SIX_MATCHES
    )
  );
  private final List<Amount> WINNING_AMOUNT = new ArrayList<>(
      List.of(
          Amount.THREE_MATCHES,
          Amount.FOUR_MATCHES,
          Amount.FIVE_MATCHES,
          Amount.FIVE_MATCHES_BONUS,
          Amount.SIX_MATCHES
      )
  );

  private final List<Integer> winningNumbers;
  private final int bonusNumber;
  private List<Integer> countOfMatches;
  private long purchaseAmount;


  public WinningManager(List<Integer> winningNumbers, int bonusNumber, long purchaseAmount) {
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
    this.countOfMatches = new ArrayList<>(List.of(0,0,0,0,0));
    this.purchaseAmount = purchaseAmount;
  }

  public void countMatchNumbers(Lotto lotto) {
    int matchNumberCount = 0, bonusNumberCheck = 0;

    List<Integer> matchCount = lotto.findMatches(winningNumbers, bonusNumber);
    matchNumberCount = matchCount.get(0);
    bonusNumberCheck = matchCount.get(1);

    storeCountMatchNumbers(matchNumberCount, bonusNumberCheck);
  }

  private void storeCountMatchNumbers(int matchNumberCount, int bonusNumberCheck) {
    if (matchNumberCount == 3 && bonusNumberCheck == 0 || (matchNumberCount == 2 && bonusNumberCheck == 1)) {
      countOfMatches.set(0, countOfMatches.get(0) + 1);
    }
    else if (matchNumberCount == 4 && bonusNumberCheck == 0 || (matchNumberCount == 3 && bonusNumberCheck == 1)) {
      countOfMatches.set(1, countOfMatches.get(1) + 1);
    }
    else if (matchNumberCount == 5 && bonusNumberCheck == 0) {
      countOfMatches.set(2, countOfMatches.get(2) + 1);
    }
    else if(matchNumberCount == 5 && bonusNumberCheck == 1) {
      countOfMatches.set(3, countOfMatches.get(3) + 1);
    }
    else if(matchNumberCount == 6) {
      countOfMatches.set(4, countOfMatches.get(4) + 1);
    }
  }

  public void printWinningStatistics() {
    for (int i = 0; i < countOfMatches.size(); i++) {
      System.out.println(WINNING_STATISTICS_COMMENT.get(i).getComment() + countOfMatches.get(i) + "개");
    }
  }

  public void printProfit() {
    System.out.println("총 수익률은 " + Math.round(calculateProfit() * 10000) / 100.0 + "%입니다.");
  }

  private double calculateProfit() {
    long totalAmount = 0L;
    for (int i = 0; i < countOfMatches.size(); i++) {
      totalAmount += (long) countOfMatches.get(i) * WINNING_AMOUNT.get(i).getAmount();
    }
    return totalAmount / (double) purchaseAmount;
  }
}
