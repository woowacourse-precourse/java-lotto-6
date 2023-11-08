package lotto.domain;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.util.NumberConverter;

public class BonusNumber {
    private static final int LOTTERY_MIN_NUM = 1;
    private static final int LOTTERY_MAX_NUM = 45;
    private static final String BLANK = " ";
    private final Lotto lotto;
    private final NumberConverter numberConverter;
    private int bonusNumber;

    public BonusNumber(Lotto lotto, NumberConverter numberConverter) {
        this.lotto = lotto;
        this.numberConverter = numberConverter;
    }

    public void validateNumber(String bonusNumber) {
        String trimedNumber = ensureNotBlank(trim(bonusNumber));
        int number = numberConverter.convert(trimedNumber);
        this.bonusNumber = checkForDuplicates(checkRangeValidity(number));
    }

    private String trim(String bonusNumber) {
        return bonusNumber.trim();
    }

    private String ensureNotBlank(String bonusNumber) {
        if (bonusNumber.contains(BLANK)) {
            throw new IllegalArgumentException(ExceptionMessage.PLEASE_NOT_INPUT_BETWEEN_NUMBER_BLANK.getMessage());
        }
        return bonusNumber;
    }

    private int checkRangeValidity(int bonusNumber) {
        if (bonusNumber > LOTTERY_MAX_NUM || bonusNumber < LOTTERY_MIN_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CORRECT_RANGE.getMessage());
        }
        return bonusNumber;
    }

    private int checkForDuplicates(int bonusNumber) {
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