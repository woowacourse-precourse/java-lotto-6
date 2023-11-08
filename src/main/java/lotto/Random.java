package lotto;

import static lotto.constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Random {

  public Lotto getRandomNumbers() {
    return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER));
  }

  public List<Lotto> createLottoGroup(int createLottoCount) {
    List<Lotto> lottoGroupList = new ArrayList<>();

    while (lottoGroupList.size() < createLottoCount) {
      lottoGroupList.add(getRandomNumbers());
    }
    return lottoGroupList;
  }
}
