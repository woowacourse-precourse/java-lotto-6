package lotto.validator;

import lotto.view.InputView;

public class BonusNumberValidator {
  public static final int MAX_LOTTO_NUMBER = 45;
  public static final int MIN_LOTTO_NUMBER = 1;
  public static final String VALUE_OUT_OF_RANGE_MESSAGE = "[ERROR] " + MIN_LOTTO_NUMBER + "와 " + MAX_LOTTO_NUMBER + " 사이의 값을 입력하시오.";

  public static void isValueInRange(String input) {
    if(Integer.parseInt(input) < MIN_LOTTO_NUMBER || Integer.parseInt(input) > MAX_LOTTO_NUMBER ){
      System.out.println(VALUE_OUT_OF_RANGE_MESSAGE);
      InputView.inputBonusNumber();
    }
  }

}
