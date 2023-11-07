package lotto.domain.lotto;

import lotto.constants.ErrorConsts;

public record LottoNumber(
        int number
) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNumber {
        validate(number);
    }

    private void validate(final int number) {
        validateRange(number);
    }

    private void validateRange(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorConsts.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
