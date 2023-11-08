package lotto.dto;

import static lotto.constants.Config.LOTTO_PRICE;

import lotto.constants.Message;

public record UserInputMoney(Long amount) {

    public UserInputMoney {
        validatePositiveAmount(amount);
        isMatchLottoPrice(amount);
    }

    private void validatePositiveAmount(Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(Message.MONEY_NEGATIVE_EXCEPTION);
        }
    }

    private void isMatchLottoPrice(Long amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Message.LOTTO_PRICE_MISMATCH_EXCEPTION);
        }
    }

    public Long getAmount() {
        return amount;
    }

    public boolean isLessThan(int value) {
        return amount < value;
    }
}
