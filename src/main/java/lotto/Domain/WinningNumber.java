package lotto.Domain;

import java.util.List;

public class WinningNumber {
  private final List<Integer> numbers;
  private final int bonusNumber;

  public WinningNumber(List<Integer> numbers, int bonusNumber) {
    validate(numbers, bonusNumber);
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  private void validate(List<Integer> numbers, int bonusNumber) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
    }
    if (numbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  // 당첨 여부 확인 메서드 등 다른 필요한 기능을 구현할 수 있습니다.
}

