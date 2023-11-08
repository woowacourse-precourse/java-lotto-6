package lotto;

import static lotto.constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {

  private static List<Integer> lottoNumberList;

  public static List<Integer> createLottoGroup() {
    lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
    List<Integer> lottoPurchased = new ArrayList<>(lottoNumberList);
    Collections.sort(lottoPurchased);

    return lottoPurchased;
  }

}
