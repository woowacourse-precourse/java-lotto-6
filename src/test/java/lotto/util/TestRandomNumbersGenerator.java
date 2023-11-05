package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Number;

public class TestRandomNumbersGenerator implements NumbersGenerator {

  private static final int MIN_RANGE = 1;
  private static final int MAX_RANGE = 6;
  private static final int FIX_SIZE = 6;

  @Override
  public List<Number> generate() {
    return Randoms
        .pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, FIX_SIZE).stream()
        .map(Number::new)
        .collect(Collectors.toList());
  }
}
