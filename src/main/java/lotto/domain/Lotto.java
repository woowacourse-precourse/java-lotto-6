package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

  private final List<Integer> numbers;
  private final int MIN_NUMBER = 1;
  private final int MAX_NUMBER = 45;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 넘버는 6개의 수를 포함해야 합니다.");
    }

    for (int number : numbers) {
      if (number < MIN_NUMBER || number > MAX_NUMBER) {
        throw new IllegalArgumentException("로또 넘버는 1부터 45 사이의 수이어야 합니다.");
      }
    }
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != numbers.size()) {
      throw new IllegalArgumentException("로또 넘버에 중복된 숫자가 있습니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
