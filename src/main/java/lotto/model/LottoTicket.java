package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

  public List<Integer> createRandomLottoNumber() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  public List<Integer> createRank() {
    return new ArrayList<>(6);
  }


}
