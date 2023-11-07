package lotto;

import lotto.util.ExceptionMessageGenerator;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int NUMBER_LOW_BOUND = 1;
    private static final int NUMBER_HIGH_BOUND = 45;
    private static final String OUT_OF_RANGE_MESSAGE = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", NUMBER_LOW_BOUND,
            NUMBER_HIGH_BOUND);

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
        return number < NUMBER_LOW_BOUND || number > NUMBER_HIGH_BOUND;
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
