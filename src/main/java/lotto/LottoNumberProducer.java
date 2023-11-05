package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberProducer {
  private List<Integer> numbers;

  public LottoNumberProducer() {
    numbers = Randoms.pickUniqueNumbersInRange(1,45, 6)
        .stream().sorted().collect(Collectors.toList());
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}