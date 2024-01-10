package lotto.numbers;

import static lotto.numbers.Lotto.MIN_LOTTO_NUMBER;
import static lotto.numbers.Lotto.MAX_LOTTO_NUMBER;
import static lotto.numbers.Lotto.SIZE_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputNumbers {

  static final int SIZE_OF_BONUS_NUMBER = 1;
  private List<Integer> receivedLottoNumbers;
  private List<Integer> bonusNumber;

  public UserInputNumbers(List<Integer> receivedLottoNumbers, List<Integer> bonusNumber) {
    validateLottoNumbers(receivedLottoNumbers);
    this.receivedLottoNumbers = receivedLottoNumbers;
    validateBonusNumbers(bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  public List<Integer> getReceivedLottoNumbers() {
    return receivedLottoNumbers;
  }

  public List<Integer> getBonusNumber() {
    return bonusNumber;
  }

  private void validateLottoNumbers(List<Integer> receivedLottoNumbers) {
    if (receivedLottoNumbers.size() != SIZE_OF_LOTTO) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
    }

    for (int number : receivedLottoNumbers) {
      if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    }

    Set<Integer> uniqueNumbers = new HashSet<>(receivedLottoNumbers);
    if (uniqueNumbers.size() < receivedLottoNumbers.size()) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }
  }

  private void validateBonusNumbers(List<Integer> bonusNumber) {
    if (bonusNumber.size() != SIZE_OF_BONUS_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개여야 합니다.");
    }

    for (int number : bonusNumber) {
      if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    }

    if (receivedLottoNumbers.containsAll(bonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }
  }
}
