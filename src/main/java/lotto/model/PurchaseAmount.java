package lotto.model;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int input) {
        validateIsAboveMinimumAmount(input);
        validateIsDivisible(input);
    }


    private void validateIsAboveMinimumAmount(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1,000원입니다.");
        }
    }

    private void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int divideByThousand() {
        return purchaseAmount / 1000;
    }

    public PrizePercentage calculatePrizePercentage(long prize) {
        return new PrizePercentage((double) prize / purchaseAmount * 100);
    }
}
