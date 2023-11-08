package lotto.service;

import java.util.ArrayList;
import lotto.domain.*;

import java.util.List;

public class LottoWinningService {

  public List<Integer> checkWinningResults(List<Lotto> userLottoList,
      WinningLottoNumbers winningNumbers) {
    List<Integer> rankCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0)); // 6개의 0으로 초기화된 리스트 생성
    for (Lotto lotto : userLottoList) {
      int rank = checkLotteryResults(lotto, winningNumbers);
      rankCount.set(rank, rankCount.get(rank) + 1);
    }
    return rankCount;
  }

  private int checkLotteryResults(Lotto lotto, WinningLottoNumbers winningNumbers) {
    List<Integer> userNumbers = lotto.getNumbers();
    List<Integer> winningNumbersList = winningNumbers.getWinningNumbers();
    int bonusNumber = winningNumbers.getBonusNumber();
    int count =  countMatchingNumbers(userNumbers, winningNumbersList);
    if (count == 6) {
      return 0; // 6개 일치 = 1등
    }
    if (count == 5 && isMatchedBonusNumber(userNumbers, bonusNumber)) {
      return 1; // 5개 일치 + 보너스 번호 일치 = 2등
    }
    if (count == 5) {
      return 2; // 5개 일치 = 3등
    }
    if (count == 4) {
      return 3; // 4개 일치 = 4등
    }
    if (count == 3) {
      return 4; // 3개 일치 = 5등
    }
    return 5; // 해당되지 않는 경우, 당첨 없음
  }

  private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbersList) {
    int count = 0;

    for (int number : userNumbers) {
      if (winningNumbersList.contains(number)) {
        count++;
      }
    }

    return count;
  }


  private boolean isMatchedBonusNumber(List<Integer> userNumbers, int bonusNumber) {
    return userNumbers.contains(bonusNumber);
  }
}
