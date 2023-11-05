package lotto.domain;

import static lotto.Exception.ExceptionMessage.RANGE_ERROR;

public class LottoNumber {

    private static int MIN_NUMBER = 1;
    private static int MAN_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number){
        if(number < MIN_NUMBER || number > MAN_NUMBER){
            throw new IllegalArgumentException(RANGE_ERROR.getExceptionMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
