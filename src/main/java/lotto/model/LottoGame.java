package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGame {

  public List<Integer> createRandomLottoNumber() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  public static void sortLottoNumbers(List<Integer> lottoNumbers) {
    Collections.sort(lottoNumbers);
  }

  public int countMatchingNumbers(List<Integer> lotto, List<Integer> winningNumberSet) {
    int matchedNumbers = 0;
    for (Integer userNumber : winningNumberSet) {
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


  public List<Integer> checkWinningStatus(List<List<Integer>> lottos, List<Integer> winningNumberSet, int bonusNumber) {
    List<Integer> rank = Lotto.createRank();
    for (List<Integer> lotto : lottos) {
      int matchedNumbers = countMatchingNumbers(lotto, winningNumberSet);
      int rankIndex = setRank(lotto, bonusNumber, matchedNumbers);
      int currentCount = rank.get(rankIndex);
      rank.set(rankIndex, currentCount + 1);
    }
    return rank;
  }
}