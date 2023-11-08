package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

  private static final List<Lotto> winLotto = new ArrayList<>();
  private final int bonusNumber;

  public WinLotto(int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  private void validateBonusNumRange(String bonusNumber) {
    if (bonusNumber.matches(".*[a-zA-Z].*"))
      throw new IllegalArgumentException(BONUS_NUMBER_WITH_LETTER_MESSAGE);

    int checkValue = Integer.parseInt(bonusNumber);

    if (checkValue > 45 || checkValue < 1)
      throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_MESSAGE);
  }

  private int isValidBonusNumber(String bonusNumber) {

    int checkValue = Integer.parseInt(bonusNumber);

    if (winLotto.contains(checkValue))
      throw new IllegalArgumentException(NON_OVERLAPPING_NUMBER_MESSAGE);

    return checkValue;
  }
}
