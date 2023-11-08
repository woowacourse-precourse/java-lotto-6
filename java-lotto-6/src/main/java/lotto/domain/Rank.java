package lotto.domain;


import static lotto.domain.Calculate.getMatchingNumber;

import java.util.List;
import lotto.Lotto;

public class Rank {
  public static int returnRank(List<Integer> winNum, Lotto oneCombination, int bonusNum) {

    int matchingNumber = getMatchingNumber(winNum, oneCombination);

    if (matchingNumber == rank.FIFTH.matchingNumber) {
      return 5;
    }
    if (matchingNumber == rank.FOURTH.matchingNumber) {
      return 4;
    }
    if (matchingNumber == rank.SECOND.matchingNumber && oneCombination.getNumbers().contains(bonusNum)) {
      return 2;
    }
    if (matchingNumber == rank.THIRD.matchingNumber) {
      return 3;
    }

    if (matchingNumber == rank.FIRST.matchingNumber) {
      return 1;
    }
    return 0;
  }

  public enum rank {
    FIRST(6, 2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000);

    final int matchingNumber;
    final int prize;

    rank(int matchingNumber, int prize) {
      this.matchingNumber = matchingNumber;
      this.prize = prize;
    }
  }

}
