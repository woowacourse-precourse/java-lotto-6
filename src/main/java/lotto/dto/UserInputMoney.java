package lotto.dto;


import static lotto.constants.Config.LOTTO_PRICE;

public record UserInputMoney(Long amount) {

    public UserInputMoney {
        validatePositiveAmount(amount);
        validateZeroAmount(amount);
        isValidateAmount(amount);
    }

    private void validatePositiveAmount(Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("");
        }
    }

    private void validateZeroAmount(Long amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("");
        }
    }

    private void isValidateAmount(Long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("");
        }
    }

    public Long getAmount() {
        return amount;
    }

    public boolean isLessThan(int value) {
        return amount < value;
    }
}
