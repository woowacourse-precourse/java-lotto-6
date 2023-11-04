package lotto.util;

import static lotto.util.Constants.CONFIG_NUMBERS_SIZE;
import static lotto.util.Constants.MAX_NUMBER_RANGE;
import static lotto.util.Constants.MIN_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Number;

public class RandomNumbersGenerator implements NumbersGenerator {

  @Override
  public List<Number> generate() {
    List<Integer> createRandomNumbers = Randoms.pickUniqueNumbersInRange(
        MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, CONFIG_NUMBERS_SIZE);

    return createRandomNumbers.stream()
        .map(Number::new)
        .toList();
  }
}
