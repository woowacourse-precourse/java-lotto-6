package lotto.domain;

public class Money {
    private final int spendAmount;

    public Money(String spendAmount) {
        validate(spendAmount);
        this.spendAmount = Integer.parseInt(spendAmount);
    }

    private void validate(String spendAmount) {
        validateIsDigit(spendAmount);
        validateDividedByThousand(spendAmount);
        validateRangeOfSpendAmount(spendAmount);
    }

    private void validateIsDigit(String spendAmount) {
    }

    private void validateRangeOfSpendAmount(String spendAmount) {
    }

    private void validateDividedByThousand(String spendAmount) {
        
    }
}
