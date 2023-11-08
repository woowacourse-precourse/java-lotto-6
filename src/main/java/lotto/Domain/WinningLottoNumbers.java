package lotto.Domain;

import java.util.List;

public class WinningLottoNumbers {

  private final List<Integer> numbers;
  private final int bonusNumber;

  public WinningLottoNumbers(List<Integer> numbers, int bonusNumber) {
    validate(numbers, bonusNumber);
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  private void validate(List<Integer> numbers, int bonusNumber) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[Error] 로또 번호의 개수는 6개여야 합니다.");
    }
    if (numbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("[Error] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

}

