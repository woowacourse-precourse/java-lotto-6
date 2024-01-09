package lotto.util;

public class PurchaseAmount {

  static final int LOTTO_PRICE = 1000;
  private int amount;

  public PurchaseAmount(int inputAmount) {
    validatePurchaseAmount(inputAmount);
    this.amount = inputAmount;
  }

  private static void validatePurchaseAmount(int inputAmount) {
    if (inputAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException();
    }
  }

  public int getAmount() {
    return amount;
  }
}
