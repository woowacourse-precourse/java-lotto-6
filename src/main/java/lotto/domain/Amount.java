package lotto.domain;

public class Amount {
    private final static int PRICE = 1000;
    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    public int calculateTotalLottoNumber() {
        return this.amount / PRICE;
    }

    public String calculateEarningsRate(long totalWinningPrize) {
        return roundOff((double) totalWinningPrize / this.amount);
    }

    private String roundOff(double earningsRate) {
        return String.format("%.1f", earningsRate * 100);
    }

    private void validateMinAmount(int amount) {
        if (amount < PRICE) {
            throw new IllegalArgumentException(
                    ErrorMessage.MIN_AMOUNT.getValue()
            );
        }
    }

    private void validateUnit(int amount) {
        if (amount % PRICE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_UNIT.getValue()
            );
        }
    }
}