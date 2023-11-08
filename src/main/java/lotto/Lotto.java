package lotto;

import java.util.List;

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
  }

  // 로또 일치하는 번호 개수 반환
  public int countMatchingNumbers(Lotto other) {
    return (int) numbers.stream().filter(other.numbers::contains).count();
  }

  public int countMatchingNumbers(int bonus) {
    return (int) numbers.stream().filter(num -> num == bonus).count();
  }

  public List<Integer> getNumbers() {
    return numbers;
  }


}
