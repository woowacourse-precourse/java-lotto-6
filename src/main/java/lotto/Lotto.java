package lotto;

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
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
    }
  // 중복된 숫자 확인
  Set<Integer> uniqueNumbers = new HashSet<>(numbers);
  if (uniqueNumbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
  }

  for (int number : numbers) {
      if (number < 1 || number > 45) {
          throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
      }
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
