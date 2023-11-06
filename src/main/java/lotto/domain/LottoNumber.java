package lotto.domain;

import lotto.Utils;

import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String input){
        int inputNumber = Utils.convertStringToInt(input);
        validate(inputNumber);
        this.number = inputNumber;
    }

    private void validate(int number) {
        if ( MAX_NUMBER < number || number < MIN_NUMBER ) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
