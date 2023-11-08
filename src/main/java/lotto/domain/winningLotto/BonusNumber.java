package lotto.domain.winningLotto;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public record BonusNumber(int number) {

    public BonusNumber {
        validate(number);
    }

    private void validate(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage()
                    .formatted(
                            LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                            LottoConstants.MAX_LOTTO_NUMBER.getValue()
                    )
            );
        }
    }

    private boolean isInvalidRange(int number) {
        return isLessThanMinimumLottoNumber(number) || isGreaterThanMaximumLottoNumber(number);
    }

    private boolean isLessThanMinimumLottoNumber(int number) {
        return number < LottoConstants.MIN_LOTTO_NUMBER.getValue();
    }

    private boolean isGreaterThanMaximumLottoNumber(int number) {
        return number > LottoConstants.MAX_LOTTO_NUMBER.getValue();
    }
}
