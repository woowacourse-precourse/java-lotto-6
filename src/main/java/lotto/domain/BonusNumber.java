package lotto.domain;

import java.util.List;
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
        this.bonusNumber = isNotDuplicate(isCorrectRange(number));
    }

    private int isCorrectRange(int bonusNumber) {
        if (bonusNumber > LOTTERY_MAX_NUM || bonusNumber < LOTTERY_MIN_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
        }
        return bonusNumber;
    }

    private int isNotDuplicate(int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS_LOTTO.getMessage());
        }
        return bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}