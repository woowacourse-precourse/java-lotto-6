package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grader {

  public Grader() {
  }

  // 로또들이랑 당첨 번호를 입력 받아 비교 로직을 실행한다.
  public List<Integer> compareLottoWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {
    List<Integer> winningDetails = new ArrayList<>();
    for(int i = 0; i <= 5; i++) {
      winningDetails.add(0);
    }
    for(Lotto lotto : lottos) {
      Integer rank = compareNumber(lotto, winningLotto);
      winningDetails.set(rank, winningDetails.get(rank) + 1);
    }
    return winningDetails;
  }

  // 로또 번호와 당첨 번호를 비교한다.
  public Integer compareNumber(Lotto lotto, WinningLotto winningLotto) {
    int sameNumberCount = 0, sameBonusNumber = 0;
    for(int i = 0; i < 6; i++) {
      for(int j = 0; j < 6; j++) {
        if(lotto.getNumbers().get(i) == winningLotto.getNumbers().get(j)) {
          sameNumberCount += 1;
        }
        if(lotto.getNumbers().get(i) == winningLotto.getBonusNumber()) {
          sameBonusNumber = 1;
        }
      }
    }
    return checkRank(sameNumberCount, sameBonusNumber);
  }

  // 일치한 번호와 보너스 번호 일치 여부를 받아 등수를 책정한다.
  public Integer checkRank(int sameNumberCount, int sameBonusNumber) {
    int rank = 0;
    if(sameNumberCount == 6) return 1;
    if(sameNumberCount == 5 && sameBonusNumber == 1)  return 2;
    if(sameNumberCount == 5) return 3;
    if(sameNumberCount == 4) return 4;
    if(sameNumberCount == 3) return 5;
    return rank;
  }

  // 구입 금액과 등수 내역을 입력 받아 수익률을 계산한다.
  public double calculateEarningRatio(Integer inputMoney, List<Integer> winningDetails) {
    double earnMoney = winningDetails.get(5) * 5000 + winningDetails.get(4) * 50000 + winningDetails.get(3) * 1500000
            + winningDetails.get(2) * 30000000 + winningDetails.get(1) * 2000000000;
    double earningRatio = (earnMoney / inputMoney) * 100.0;
    earningRatio = Math.round(earningRatio * 10.0) / 10.0;
    return earningRatio;
  }



}
