package lotto.validator;

import java.util.List;

public class InputLottoWinningNumbersValidator {
  public static final String EMPTY_WINNING_NUMBER_MESSAGE = "[ERROR] 공백을 입력하였습니다.";

  public static void isEmptyString(List<String> WinningNumbers) throws IllegalArgumentException {
    for (String element : WinningNumbers) {
      if (element != null && element.trim().isEmpty()) {
        throw new IllegalArgumentException (EMPTY_WINNING_NUMBER_MESSAGE);
      }
    }
  }


}
