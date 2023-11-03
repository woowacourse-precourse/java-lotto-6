package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoTicket {

  public List<Integer> createRandomLottoNumber() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

}
