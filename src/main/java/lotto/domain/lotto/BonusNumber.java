package lotto.domain.lotto;

import static lotto.io.ErrorMessage.NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final int number;

    public BonusNumber(int number) {
        validateLottoInRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateLottoInRange(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

}
