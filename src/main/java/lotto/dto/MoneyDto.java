package lotto.dto;

import lotto.util.consts.ErrorMessage;
import lotto.util.consts.IntValueConst;

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
            throw new IllegalArgumentException(ErrorMessage.MINUS_MONEY.getMessage());
        }
    }

    private void validateDividedByLottoPrice(int amount) {
        if (amount % IntValueConst.SINGLE_LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }
}
