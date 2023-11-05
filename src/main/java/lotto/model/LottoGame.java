package lotto.model;

import java.util.List;

public class LottoGame {

  public int countMatchingNumbers(List<Integer> lotto, List<String> winningNumbers) {
    int matchedNumbers = 0;
    for (String userNumber : winningNumbers) {
      if (lotto.contains(userNumber)) {
        matchedNumbers++;
      }
    }
    return matchedNumbers;
  }

  public int setRank(List<Integer> lotto, int bonusNumber, int matchedNumbers) {
    if (matchedNumbers == 6) {
      return 1;
    }
    if (matchedNumbers == 5) {
      return matchBonusNumber(lotto, bonusNumber);
    }
    if (matchedNumbers == 4) {
      return 4;
    }
    if (matchedNumbers == 3) {
      return 5;
    }
    return 0;
  }

  public int matchBonusNumber(List<Integer> lotto, int bonusNumber) {
    if (lotto.contains(bonusNumber)) {
      return 2;
    }
    return 3;
  }


  public List<Integer> checkWinningStatus(List<List<Integer>> lottos, List<Integer> winningNumbers, int bonusNumber) {
    List<Integer> rank = Lotto.createRank();
    for (List<Integer> lotto : lottos) {
      int matchedNumbers = countMatchingNumbers(lotto, winningNumbers);
      int rankIndex = setRank(lotto, bonusNumber, matchedNumbers);
      int currentCount = rank.get(rankIndex);
      rank.set(rankIndex, currentCount + 1);
    }
    return rank;
  }
}