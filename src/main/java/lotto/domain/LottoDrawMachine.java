package lotto.domain;

import lotto.message.ErrorMessage;

public class LottoDrawMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lottoNumber;
    private final int bonusNumber;

    public LottoDrawMachine(Lotto lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int number) {
        checkValidRange(number);
        checkDuplicate(number);
    }

    private void checkValidRange(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage());
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage());
        }
    }

    private void checkDuplicate(int number) {
        if (this.lottoNumber.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_LOTTO.getMessage());
        }
    }

}
