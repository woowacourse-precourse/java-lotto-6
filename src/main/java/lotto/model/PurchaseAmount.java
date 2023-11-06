package lotto.model;

public record PurchaseAmount(
        int purchaseAmount
) {

    public PurchaseAmount {
        validate(purchaseAmount);
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

    public PrizePercentage calculatePrizePercentage(Result result) {
        long prize = result.calculatePrize();
        return new PrizePercentage((double) prize / purchaseAmount * 100);
    }
}
