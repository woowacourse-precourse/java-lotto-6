package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }
    Set<Integer> uniqueNumbers = new HashSet<>(numbers);
    if (uniqueNumbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  @Override
  public String toString() {
    return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]\n"));
  }
}
