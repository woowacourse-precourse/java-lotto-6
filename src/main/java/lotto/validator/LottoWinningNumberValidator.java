package lotto.validator;

import java.util.List;
import lotto.view.InputView;

public class LottoWinningNumberValidator {
  public static final int MAX_LOTTO_NUMBER = 45;
  public static final int MIN_LOTTO_NUMBER = 1;
  public static final String VALUE_OUT_OF_RANGE_MESSAGE = "[ERROR] " + MIN_LOTTO_NUMBER + "와 " + MAX_LOTTO_NUMBER + " 사이의 값을 입력하시오.";

  public static void isValueInRange(List<String> WinningNumbers) {
    for (String number : WinningNumbers) {
      try {
        int num = Integer.parseInt(number);
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
          throw new IllegalArgumentException(VALUE_OUT_OF_RANGE_MESSAGE);
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        InputView.inputBonusNumber();
      }
    }
  }


}
