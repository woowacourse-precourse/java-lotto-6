package lotto.model;

public class PurchaseMoney {

  private static final int MIN_PRICE = 1000;
  private static final int DIVIDE_MONEY = 1000;

  private int purchaseMoney;

  public PurchaseMoney(int purchaseMoney) {
    validate(purchaseMoney);
    this.purchaseMoney = purchaseMoney;
  }

  public int getPurchaseAmount() {
    return purchaseMoney / DIVIDE_MONEY;
  }

  public int getPurchaseMoney() {
    return purchaseMoney;
  }

  private void validate(int purchaseMoney) {
    validateMinPrice(purchaseMoney);
    validateAmount(purchaseMoney);
  }

  private void validateMinPrice(int purchaseMoney) {
    if (purchaseMoney < MIN_PRICE) {
      throw new IllegalArgumentException("최소 구입 금액은 1,000원 이상입니다.");
    }
  }

  private void validateAmount(int purchaseMoney) {
    if (isDivisible(purchaseMoney)) {
      throw new IllegalArgumentException("구입 금액은 1,000원 단위입니다.");
    }
  }

  private boolean isDivisible(int purchaseMoney) {
    return purchaseMoney % DIVIDE_MONEY != 0;
  }

}
