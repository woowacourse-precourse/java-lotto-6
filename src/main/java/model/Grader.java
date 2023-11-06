package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grader {

  public Grader() {
  }

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

  public Integer checkRank(int sameNumberCount, int sameBonusNumber) {
    int rank = 0;
    if(sameNumberCount == 6) {
       rank = 1;
    }
    else if(sameNumberCount == 5 && sameBonusNumber == 1) {
      rank = 2;
    }
    else if(sameNumberCount == 5) {
      rank = 3;
    }
    else if(sameNumberCount == 4) {
      rank = 4;
    }
    else if(sameNumberCount == 3) {
      rank = 5;
    }
    return rank;
  }

}
