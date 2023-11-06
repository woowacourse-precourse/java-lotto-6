package lotto.validator;

import lotto.view.InputView;

public class PurchaseAmountValidator {
  public static final String AMOUNTNOTNUMBER = "[ERROR] 숫자가 아닙니다.";
  public static final String AMOUNTOVER1000 = "[ERROR] 1000원 이상 입력해 주세요.";
  public static void isAllIntegersValid(String input) {
    if (!input.matches("^[0-9\\s]+$")) {
      System.out.println(AMOUNTNOTNUMBER);
      InputView.inputMoney();
    }
  }

  public static void isAmountGreaterThanOrEqualTo1000(String input) {
    if(Integer.parseInt(input) < 1000) {
      System.out.println(AMOUNTOVER1000);
      InputView.inputMoney();
    }
  }


}
