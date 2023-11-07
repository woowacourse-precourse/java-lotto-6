package lotto.model;

import static lotto.message.ErrorMessage.NON_DIVISIBLE_BY_THOUSAND;
import static lotto.message.ErrorMessage.UNDER_MINIMUM_PURCHASE_AMOUNT_ERROR;

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
            throw new IllegalArgumentException(UNDER_MINIMUM_PURCHASE_AMOUNT_ERROR.getValue());
        }
    }

    private void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(NON_DIVISIBLE_BY_THOUSAND.getValue());
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
