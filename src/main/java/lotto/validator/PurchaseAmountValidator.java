package lotto.validator;

import lotto.view.InputView;

public class PurchaseAmountValidator {
  public static final String AMOUNTNOTNUMBER = "[ERROR] 숫자가 아닙니다.";
  public static boolean validateAllIntegers(String input) {
    if (!input.matches("^[0-9\\s]+$")) {
      System.out.println(AMOUNTNOTNUMBER);
      InputView.inputMoney();
    }
    return true;
  }
}
