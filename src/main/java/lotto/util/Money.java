package lotto.util;

public class Money {

  public static final int LOTTO_PRICE = 1000;
  private int amount;

  public Money(String input) {
    validateIsNumeric(input);
    int inputAmount = Integer.parseInt(input);
    validatePurchaseAmount(amount);
    this.amount = inputAmount;
  }

  private static void validateIsNumeric(String inputAmount) {
    try {
      Integer.parseInt(inputAmount);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야합니다.");
    }
  }

  private static void validatePurchaseAmount(int inputAmount) {
    if (inputAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력하세요.");
    }
  }

  public int getAmount() {
    return amount;
  }
}