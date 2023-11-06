package lotto;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6 || numbers.stream().anyMatch(number -> number < 1 || number > 45) || numbers.stream().distinct().count() != 6) {
      throw new IllegalArgumentException();
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int size() {
    return numbers.size();
  }

  @Override
  public String toString() {
    return "Lotto{" +
        "numbers=" + numbers +
        '}';
  }
}
