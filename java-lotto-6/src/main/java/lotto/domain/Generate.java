package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Generate {
  public static List<Integer> generateRandomNumbers() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  public static void generateLotto(Lotto[] myLotto) {
    for (int i = 0; i < myLotto.length; i++) {
      myLotto[i] = new Lotto(generateRandomNumbers());
      Collections.sort(myLotto[i].getNumbers());
    }
  }
}
