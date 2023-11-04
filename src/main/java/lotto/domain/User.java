package lotto.domain;

public class User {
    private final int amount;

    public User(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        amount = Integer.parseInt(purchaseAmount);
    }

    public int getAmount() {
        return amount;
    }

    private void validatePurchaseAmount(String purchaseAmount){
        validateOnlyNumberAmount(purchaseAmount);
        int purchasedAmount = Integer.parseInt(purchaseAmount);
        validate1000UnitAmount(purchasedAmount);
        validateZeroAmount(purchasedAmount);
    }

    private void validateOnlyNumberAmount(String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력되어야 합니다.");
        }
    }

    private void validateZeroAmount(int purchasedAmount) {
        if(purchasedAmount == 0){
            throw new IllegalArgumentException("[ERROR] 구액 금액은 최소 1000원입니다.");
        }
    }

    private void validate1000UnitAmount(int purchasedAmount) {
        if (purchasedAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
