package lotto.ui;

public record UserInputMoney(Integer amount) {
    private static final Integer LOTTO_PRICE = 1_000;

    public UserInputMoney {
        isValidateAmount(amount);
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
