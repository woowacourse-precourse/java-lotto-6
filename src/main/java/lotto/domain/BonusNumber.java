package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;

public class BonusNumber {
    private static final int LOTTERY_MIN_NUM = 1;
    private static final int LOTTERY_MAX_NUM = 45;
    private final Lotto lotto;
    private final NumberConverter numberConverter;
    private int bonusNumber;

    public BonusNumber(Lotto lotto, NumberConverter numberConverter) {
        this.lotto = lotto;
        this.numberConverter = numberConverter;
    }

    public void validateNumber(String bonusNumber) {
        int number = numberConverter.convert(bonusNumber);
        this.bonusNumber = isCorrectRange(number);
    }

    private int isCorrectRange(int bonusNumber) {
        if (bonusNumber > LOTTERY_MAX_NUM || bonusNumber < LOTTERY_MIN_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
        }
        return bonusNumber;
    }

}
