package lotto.validator;

import lotto.view.InputView;

public class PurchaseAmountValidator {
  public static final String AMOUNT_NOT_NUMBER_MESSAGE = "[ERROR] 숫자가 아닙니다.";
  public static final String AMOUNT_OVER_1000_MESSAGE = "[ERROR] 1000원 이상 입력해 주세요.";
  public static final String AMOUNT_NOT_DIVISIBLE_MESSAGE = "[ERROR] 1000원으로 나누어 떨어지지 않습니다.";
  public static final String EMPTY_STRING_MESSAGE = "[ERROR] 공백을 입력하였습니다.";
  public static final int TICKET_PRICE = 1000;

  public static void isAllIntegersValid(String input) throws IllegalArgumentException {
    if (!input.matches("^[0-9\\s]+$")) {
      throw new IllegalArgumentException(AMOUNT_NOT_NUMBER_MESSAGE);
    }
  }

  public static void isAmountGreaterThanOrEqualTo1000(String input) throws IllegalArgumentException {
    if(Integer.parseInt(input) < TICKET_PRICE) {
      throw new IllegalArgumentException(AMOUNT_OVER_1000_MESSAGE);
    }
  }

  public static void isDivisibleBy1000(String input) throws IllegalArgumentException {
    if (Integer.parseInt(input) % TICKET_PRICE != 0) {
      throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE_MESSAGE);
    }
  }

  public static void isEmptyString(String input) throws IllegalArgumentException {
    if(input.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STRING_MESSAGE);
    }
  }

}
