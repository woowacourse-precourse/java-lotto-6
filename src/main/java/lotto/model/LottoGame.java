package lotto.model;

import java.util.List;

public class LottoGame {

  public int countMatchingNumbers(List<Integer> ticket, List<Integer> numbers) {
    int matchedNumbers = 0;
    for (int userNumber : numbers) {
      if (ticket.contains(userNumber)) {
        matchedNumbers++;
      }
    }
    return matchedNumbers;
  }

  public int matchingBonusNumber(List<Integer> ticket, int bonusNumber, int matchedNumbers) {
    if (matchedNumbers == 6) {
      return -1;
    }

    if (ticket.contains(bonusNumber)) {
      return matchedNumbers + 1;
    }

    return matchedNumbers;
  }

  private void updateRank(List<Integer> rank, int matchedNumbers) {
    if (matchedNumbers == -1) {
      int currentCount = rank.get(0);
      rank.set(0, currentCount + 1);
    }

    if (matchedNumbers > 2) {
      int currentCount = rank.get(matchedNumbers - 2);
      rank.set(matchedNumbers - 2, currentCount + 1);
    }
  }


}