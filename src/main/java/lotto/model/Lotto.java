package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.validation.LotteryNumberValidator;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    LotteryNumberValidator.validateLottoSize(numbers);
    LotteryNumberValidator.checkDuplicate(numbers);
    Collections.sort(numbers); // 오름차순 정렬
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

}
