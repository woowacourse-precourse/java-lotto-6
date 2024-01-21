package lotto.domain;

import lotto.util.ErrorMessage;

public class PurchaseAmount {

  public static final int LOTTO_PRICE = 1000;
  private final int purchaseAmount;

  public PurchaseAmount(int inputAmount) {
    validatePurchaseAmount(inputAmount);
    this.purchaseAmount = inputAmount;
  }

  private void validatePurchaseAmount(int inputAmount) {
    if (inputAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException(ErrorMessage.NOT_A_UNIT_OF_1000.getMessage());
    }
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }
}
