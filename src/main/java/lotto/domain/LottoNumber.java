package lotto.domain;

import lotto.enums.ErrorMessages;
import lotto.enums.LottoEnum;

public class LottoNumber {
    private final int number;

    public LottoNumber(String stringNumber) {
        try {
            int parsedNumber = Integer.parseInt(stringNumber.trim());
            validate(parsedNumber);
            this.number = parsedNumber;
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
        }
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (number < LottoEnum.MIN_LOTTO_NUMBER.getValue()
                || number > LottoEnum.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
