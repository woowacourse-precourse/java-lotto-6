package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grader {

  static int[] result;
  static boolean[] bonus;
  static int earningRate;

  public Grader() {
  }

  public void compareLottoWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {

  }

  public Map<String, Integer> compareNumber(Lotto lotto, WinningLotto winningLotto) {
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
    Map<String, Integer> result = new HashMap<>();
    result.put("sameNumberCount", sameNumberCount);
    result.put("sameBonusNumber", sameBonusNumber);
    return result;
  }

}
