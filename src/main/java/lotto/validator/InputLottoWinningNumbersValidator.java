package lotto.validator;

import static lotto.view.InputView.inputWinningNumber;

import java.util.List;
import lotto.view.InputView;

public class InputLottoWinningNumbersValidator {
  public static final String EMPTY_WINNING_NUMBER_MESSAGE = "[ERROR] 공백을 입력하였습니다.";

  public static void isEmptyString(List<String> WinningNumbers) throws IllegalArgumentException {
    for (String element : WinningNumbers) {
      if (element != null && element.trim().isEmpty()) {
        System.out.println(EMPTY_WINNING_NUMBER_MESSAGE);
        InputView.inputWinningNumber();
      }
    }
  }


}
