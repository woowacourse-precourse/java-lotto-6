package lotto.domain;

import static lotto.LottoConstants.NUMBER_HIGH_BOUND;
import static lotto.LottoConstants.NUMBER_LOW_BOUND;

import lotto.util.ExceptionMessageGenerator;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String OUT_OF_RANGE_MESSAGE = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            NUMBER_LOW_BOUND.getValue(),
            NUMBER_HIGH_BOUND.getValue());

    private final int number;

    public LottoNumber(long number) {
        validate(number);
        this.number = (int) number;
    }

    private void validate(long number) {
        ExceptionMessageGenerator exceptionMessageGenerator = ExceptionMessageGenerator.INSTANCE;

        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(exceptionMessageGenerator.makeMessage(OUT_OF_RANGE_MESSAGE));
        }
    }

    private boolean isOutOfRange(long number) {
        return number < NUMBER_LOW_BOUND.getValue() || number > NUMBER_HIGH_BOUND.getValue();
    }

    public String getNumberMessage() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object object) {
        LottoNumber others = (LottoNumber) object;

        return number == others.number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }
}
