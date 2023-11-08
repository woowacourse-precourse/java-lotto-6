package lotto.domain;

import lotto.view.ExceptionMessage;
public class UserBuyLotto {
  private static final int LOTTO_VALUE = 1000;
  private final int price;

  public UserBuyLotto(String price) {
    int validatedNumber = validateNumber(price);
    validatedPrice(validatedNumber);
    this.price = validatedNumber;
  }

  public int calculateLottoCount() {
    return price / LOTTO_VALUE;
  }



  // 로또 금액 단위와 맞는지 확인한다.
  private void validatedPrice(int amount) {
    if (amount <= 0) {
      ExceptionMessage.naturalException();
      throw new IllegalArgumentException();
    }
    if (amount % LOTTO_VALUE != 0) {
      ExceptionMessage.divisibleException();
      throw new IllegalArgumentException();
    }
  }
  // 숫자인지 확인한다.
  private static int validateNumber(String price) throws IllegalArgumentException {
    try {
      return Integer.parseInt(price);
    } catch (NumberFormatException e) {
      ExceptionMessage.numberException();
      throw new IllegalArgumentException();
    }
  }
}
