package lotto;

import static lotto.constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    for (int value : numbers) {
      if (value >= MIN_NUMBER && value <= MAX_NUMBER) {
        continue;
      }
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자를 입력해야 합니다.");
    }
    validateUniqueNumber(numbers);
  }

  private void validateUniqueNumber(List<Integer> numbers) {
    if (!checkUniqueNumber(numbers)) {
      throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자를 입력해야 합니다.");
    }
  }

  private boolean checkUniqueNumber(List<Integer> numbers) {
    Set<Integer> checkUniqueNumber = new HashSet<>();
    for (int num : numbers) {
      if (!checkUniqueNumber.add(num)) {
        return false;
      }
    }
    return true;
  }

}
