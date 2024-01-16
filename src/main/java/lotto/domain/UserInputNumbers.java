package lotto.domain;

import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.SIZE_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputNumbers {

  private List<Integer> receivedLottoNumbers;
  private int bonusNumber;

  public UserInputNumbers(List<Integer> receivedLottoNumbers, int bonusNumber) {
    validateLottoNumbers(receivedLottoNumbers);
    this.receivedLottoNumbers = receivedLottoNumbers;
    validateBonusNumbers(bonusNumber);
    this.bonusNumber = bonusNumber;
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

  private void validateBonusNumbers(int bonusNumber) {
    if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    if (new HashSet<>(receivedLottoNumbers).contains(bonusNumber)) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }
  }

  public List<Integer> getReceivedLottoNumbers() { // 결과 계산에 호출됨
    return receivedLottoNumbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }
}
