package lotto.Service;

import lotto.Domain.Lotto;
import lotto.Domain.WinningLottoNumbers;

import java.util.List;

public class LottoWinningService {

  public int[] checkWinningResults(List<Lotto> userLottoList, WinningLottoNumbers winningNumbers) {
    int[] matchCounts = new int[6];
    for (Lotto lotto : userLottoList) {
      int count = countMatchingNumbers(lotto.getNumbers(), winningNumbers.getWinningNumbers());
      matchCounts[count]++;
    }
    return matchCounts;
  }

  private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
    int count = (int) userNumbers.stream().filter(winningNumbers::contains).count();

    if (count == 6) {
      return 1; // 6개 일치 = 1등
    }
    if (count == 5 && isMatchedBonusNumber(userNumbers, winningNumbers.getBonusNumber())) {
      return 2; // 5개 일치 + 보너스 볼 일치 = 2등
    }
    if (count == 5) {
      return 3; // 5개 일치 = 3등
    }
    if (count == 4) {
      return 4; // 4개 일치 = 4등
    }
    if (count == 3) {
      return 5; // 3개 일치 = 5등
    }
    return 0; // 해당되지 않는 경우, 당첨 없음
  }

  private boolean isMatchedBonusNumber(List<Integer> userNumbers, int bonusNumber) {
    return userNumbers.contains(bonusNumber);
  }
}
