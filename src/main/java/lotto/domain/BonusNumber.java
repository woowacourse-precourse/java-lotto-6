package lotto.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private final Integer number;

    public BonusNumber(Integer number, WinnerNumbers winnerNumbers) {
        validateRange(number);
        validateDuplicate(number, winnerNumbers);
        this.number = number;
    }

    private void validateRange(Integer number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUND_LOTTO_NUMBER.toMessage());
        }
    }

    private void validateDuplicate(Integer number, WinnerNumbers winnerNumbers) {
        if(winnerNumbers.isMatched(number))
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.toMessage());
    }

    public Boolean isMatched(Integer findNumber) {
        if(findNumber.equals(number)) return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
