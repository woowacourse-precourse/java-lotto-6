package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE_START;
import static lotto.view.ErrorConstants.OUT_OF_RANGE_NUMBER_ERROR_MESSAGE;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber create(int number) {
        return new LottoNumber(number);
    }

    private boolean isOutOfRange(int number) {
        return number < LOTTO_NUMBER_RANGE_START.getValue() || number > LOTTO_NUMBER_RANGE_END.getValue();
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(
                    String.format(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE.getMessage(),
                            LOTTO_NUMBER_RANGE_START.getValue(),
                            LOTTO_NUMBER_RANGE_END.getValue()));
        }
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.number, other.number);
    }

    public int getNumber() {
        return number;
    }
}
