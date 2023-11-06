package lotto.model;

public class LottoNumber {
    private static final Integer NUMBER_MIN_RANGE = 1;
    private static final Integer NUMBER_MAX_RANGE = 45;
    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Integer number;

    public LottoNumber(Integer number) {
        validateNumberRange(number);
        this.number = number;
    }

    private static void validateNumberRange(int number) {
        if (number < NUMBER_MIN_RANGE || number > NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }
}
