package lotto.ui;

public record UserInputMoney(Integer amount) {
    private static final Integer LOTTO_PRICE = 1_000;

    public UserInputMoney {
        validatePositiveAmount(amount);
        validateZeroAmount(amount);
        isValidateAmount(amount);
    }

    private void validatePositiveAmount(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateZeroAmount(Integer amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("");
        }
    }

    private void isValidateAmount(Integer amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("");
        }
    }

    public Integer getAmount() {
        return amount;
    }
}
