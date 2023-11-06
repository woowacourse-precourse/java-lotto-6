package lotto;

public class LottoNumber {
    private static final int NUMBER_LOW_BOUND = 1;
    private static final int NUMBER_HIGH_BOUND = 45;
    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private static final String OUT_OF_RANGE_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";

    private final int lottoNumber;


    public LottoNumber(long number) {
        validate(number);
        lottoNumber = (int) number;
    }

    private void validate(long nubmer) {
        if (isOutOfRange(nubmer)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER + OUT_OF_RANGE_MESSAGE);
        }
    }

    private boolean isOutOfRange(long number) {
        return number < NUMBER_LOW_BOUND || number > NUMBER_HIGH_BOUND;
    }

    @Override
    public boolean equals(Object object) {
        LottoNumber others = (LottoNumber) object;

        return lottoNumber == others.lottoNumber;
    }
}
