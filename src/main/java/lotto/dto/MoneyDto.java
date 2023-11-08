package lotto.dto;

import lotto.util.consts.Consts;

import static lotto.util.consts.ErrorMessage.MINUS_MONEY;
import static lotto.util.consts.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE;

public record MoneyDto(int amount) {

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
        if (amount % Consts.SINGLE_LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }
}
