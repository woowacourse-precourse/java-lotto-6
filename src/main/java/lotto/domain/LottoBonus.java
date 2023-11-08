package lotto.domain;

import static lotto.message.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR;

public class LottoBonus {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final int number;

    public LottoBonus(int number) {
        isNumberRangeValid(number);
        this.number = number;
    }

    private void isNumberRangeValid(int number) {
        if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }

}
