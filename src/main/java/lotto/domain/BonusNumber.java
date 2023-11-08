package lotto.domain;

import lotto.message.ExceptionMessage;

public record BonusNumber(int number) {
    public BonusNumber {
        validate(number);
    }

    private void validate(int number) {
        validateBonusInRange(number);
    }

    private void validateBonusInRange(int number) {
        if (number < LottoOption.LOTTO_START_INCLUSIVE ||
                number > LottoOption.LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
    }
}
