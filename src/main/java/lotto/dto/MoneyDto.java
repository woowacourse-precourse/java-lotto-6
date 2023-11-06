package lotto.dto;

import static lotto.util.ErrorMessage.MINUS_MONEY;
import static lotto.util.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE;

public record MoneyDto(int amount) {

    private static final int SINGLE_LOTTO_PRICE = 1000;

    public MoneyDto {
        validate(amount);
    }

    private void validate(int amount) {
        validateNotMinus(amount);
        validateDividedByLottoPrice(amount);
    }

    private void validateNotMinus(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(MINUS_MONEY.getMessage());
        }
    }

    private void validateDividedByLottoPrice(int amount) {
        if (amount % SINGLE_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }
}
