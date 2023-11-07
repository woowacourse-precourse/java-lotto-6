package lotto.domain;

public class Money {
    private final int spendAmount;

    public Money(String spendAmount) {
        validate(spendAmount);
        this.spendAmount = spendAmount;
    }

    private void validate(String spendAmount) {
        validateDividedByThousand(spendAmount);
        validateRangeOfSpendAmount(spendAmount);
    }

    private void validateRangeOfSpendAmount(String spendAmount) {
    }

    private void validateDividedByThousand(String spendAmount) {
        
    }
}
