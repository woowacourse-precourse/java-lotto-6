package lotto.domain;

public class PurchaseAmount {

  public static final int LOTTO_PRICE = 1000;
  private final int purchaseAmount;

  public PurchaseAmount(int inputAmount) {
    validatePurchaseAmount(inputAmount);
    this.purchaseAmount = inputAmount;
  }

  private void validatePurchaseAmount(int inputAmount) {
    if (inputAmount % LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("[ERROR] 1000 단위의 금액이어야 합니다.");
    }
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }
}
