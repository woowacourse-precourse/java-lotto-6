package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

  private static final String BONUS_NUMBER_WITH_LETTER_MESSAGE = "[ERROR] 숫자 하나만 입력해 주세요.";
  private static final String INVALID_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 입력 가능한 숫자의 범위는 1~45까지 입니다.";
  private static final String NON_OVERLAPPING_NUMBER_MESSAGE = "[ERROR] 당첨 번호와 겹치지 않는 숫자를 입력해 주세요.";

  private final List<Integer> winLotto;
  private final int bonusNumber;

  private WinLotto(List<Integer> winLotto, String bonusNumber) {
    this.winLotto = winLotto;
    validateBonusNumRange(bonusNumber);
    this.bonusNumber = isValidBonusNumber(bonusNumber);
  }

  public static WinLotto setWinLotto(List<Integer> numbers, String bonusNumber) {
    return new WinLotto(numbers, bonusNumber);
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
