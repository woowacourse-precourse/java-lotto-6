package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

  private static final Integer MIN_RANGE_VALUE = 1;
  private static final Integer MAX_RANGE_VALUE = 45;
  private static final Integer NUM_OF_VALUES_TO_PICK = 6;

  @Override
  public List<Integer> generate() {
    return Randoms.pickUniqueNumbersInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE,
        NUM_OF_VALUES_TO_PICK);
  }
}
