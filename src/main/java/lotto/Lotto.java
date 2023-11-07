package lotto;

import java.util.*;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 6개 숫자여야 합니다.");
    }
    if (hasDuplicates(numbers)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 있습니다.");
    }
    Collections.sort(numbers);
  }

  private boolean hasDuplicates(List<Integer> numbers) {
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    return uniqueNumbers.size() != numbers.size();
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
