package lotto.domain;

import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.SIZE_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;

public class UserInputNumbers {

  private final List<Integer> receivedLottoNumbers;
  private final int bonusNumber;

  public UserInputNumbers(List<Integer> receivedLottoNumbers, int bonusNumber) {
    validateLottoNumbers(receivedLottoNumbers);
    this.receivedLottoNumbers = receivedLottoNumbers;
    validateBonusNumbers(bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  private void validateLottoNumbers(List<Integer> receivedLottoNumbers) {
    if (receivedLottoNumbers.size() != SIZE_OF_LOTTO) {
      throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
    }

    for (int number : receivedLottoNumbers) {
      if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
        throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
      }
    }

    Set<Integer> uniqueNumbers = new HashSet<>(receivedLottoNumbers);
    if (uniqueNumbers.size() < receivedLottoNumbers.size()) {
      throw new IllegalArgumentException(ErrorMessage.MUST_NOT_DUPLICATE.getMessage());
    }
  }

  private void validateBonusNumbers(int bonusNumber) {
    if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
    }

    if (new HashSet<>(receivedLottoNumbers).contains(bonusNumber)) {
      throw new IllegalArgumentException(ErrorMessage.MUST_NOT_DUPLICATE.getMessage());
    }
  }

  public List<Integer> getReceivedLottoNumbers() { // 결과 계산에 호출됨
    return receivedLottoNumbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }
}
