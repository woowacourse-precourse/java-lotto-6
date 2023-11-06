package lotto.model;

public class PurchaseMoney {

  private static final int DIVIDE_MONEY = 1000;

  private int purchaseMoney;

  public PurchaseMoney(int purchaseMoney) {
    validateAmount(purchaseMoney);
    this.purchaseMoney = purchaseMoney;
  }

  private void validateAmount(int purchaseMoney) {
    if (isDivisible(purchaseMoney)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isDivisible(int purchaseMoney) {
    return purchaseMoney % DIVIDE_MONEY != 0;
  }
}
