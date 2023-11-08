package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinLotto {

  private static final String REGEX_ALPHABET_PATTERN = ".*[a-zA-Z].*";
  private static final String WINNING_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 문자를 포함하지 않고 '1,2,3,4,5,6' 형식으로 입력해 주세요.";
  private static final String BONUS_NUMBER_WITH_LETTER_MESSAGE = "[ERROR] 숫자 하나만 입력해 주세요.";
  private static final String INVALID_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 입력 가능한 보너스 숫자의 범위는 1~45까지 입니다.";
  private static final String NON_OVERLAPPING_BONUS_NUMBER_MESSAGE = "[ERROR] 당첨 번호와 겹치지 않는 보너스 숫자를 입력해 주세요.";

  private final List<Integer> winLotto;
  private final int bonusNumber;

  private WinLotto(Lotto winLotto, String bonusNumber) {
    this.winLotto = winLotto.getNumbers();
    validateBonusNumRange(bonusNumber);
    this.bonusNumber = isValidBonusNumber(bonusNumber);
  }

  public static WinLotto setWinLotto(String winningLottery, String bonusNumber) {

    List<Integer> winLotto = validateWinningNumbers(winningLottery);

    Lotto lotto = new Lotto(winLotto);

    return new WinLotto(lotto, bonusNumber);
  }

  private static List<Integer> validateWinningNumbers(String winningLottery) {

    List<Integer> checkValue = Arrays.stream(winningLottery.split(","))
        .map(value -> {
          if (value.matches(REGEX_ALPHABET_PATTERN))
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);

          return Integer.parseInt(value);
        })
        .toList();

    return new ArrayList<>(checkValue);
  }

  public List<Integer> getWinLotto() {
    return winLotto;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  private void validateBonusNumRange(String bonusNumber) {
    if (bonusNumber.matches(REGEX_ALPHABET_PATTERN))
      throw new IllegalArgumentException(BONUS_NUMBER_WITH_LETTER_MESSAGE);

    int checkValue = Integer.parseInt(bonusNumber);

    if (checkValue > 45 || checkValue < 1)
      throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE_MESSAGE);
  }

  private int isValidBonusNumber(String bonusNumber) {

    int checkValue = Integer.parseInt(bonusNumber);
    List<Integer> winLottoList = new ArrayList<>(winLotto);

    if (winLottoList.contains(checkValue))
      throw new IllegalArgumentException(NON_OVERLAPPING_BONUS_NUMBER_MESSAGE);

    return checkValue;
  }
}
