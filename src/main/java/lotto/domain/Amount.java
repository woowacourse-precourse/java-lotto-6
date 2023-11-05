package lotto.domain;

public class Amount {
    private final static int PRICE = 1000;
    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    private void validate(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    public int calculateTotalLottoNumber() {
        return this.amount / PRICE;
    }

    public String getTotalEarningsRate(long totalWinningPrize) {
        return roundOff(this.amount / (double) totalWinningPrize);
    }

    private String roundOff(double earningRate) {
        return String.format("%.2f", earningRate);
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

