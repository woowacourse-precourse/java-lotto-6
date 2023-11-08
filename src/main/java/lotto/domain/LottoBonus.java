package lotto.domain;

import lotto.constant.ExceptionType;
import lotto.constant.LottoConstant;
import lotto.util.TypeConverter;

public class LottoBonus {
    private final int number;

    public LottoBonus(Lotto winningLotto, String number) {
        try {
            this.number = TypeConverter.convertToInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_NOT_INTEGER.getMessage());
        }

        validate(winningLotto, this.number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(Lotto winningLotto, int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(ExceptionType.LOTTO_OUT_OF_RANGE.getMessage());
        } else if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(ExceptionType.BONUS_INCLUDED_IN_WINNING_LOTTO.getMessage());
        }
    }

    private boolean isInRange(int number) {
        return (number >= LottoConstant.RANGE_BEGIN.getNumber()) && (number <= LottoConstant.RANGE_END.getNumber());
    }
}
