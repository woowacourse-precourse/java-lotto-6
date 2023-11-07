package lotto;

import static lotto.constants.*;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != COUNT_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }
  }

  // TODO: 추가 기능 구현
}
