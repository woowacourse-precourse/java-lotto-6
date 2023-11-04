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

  public void checkWinningStatus(List<List<Integer>> lottos, List<Integer> numbers) {
    List<Integer> rank = Lotto.createRank();
    for (List<Integer> lotto : lottos) {
      int matchedNumbers = countMatchingNumbers(lotto, numbers);

    }
  }

}