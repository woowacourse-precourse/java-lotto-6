package lotto.Domain;

import lotto.Constant.Constant;

public class LottoNumber {
    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닌 값이 들어있습니다.";
    private static final String OUT_OF_RANGE_MESSAGE = "범위에 초과하는 숫자가 들어있습니다.";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validate(String lottoNumber) {
        validateIsNumber(lottoNumber);
        validateInRange(lottoNumber);
    }

    private void validateIsNumber(String lottoNumber) {
        if (!lottoNumber.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + NOT_NUMBER_MESSAGE);
        }
    }

    private void validateInRange(String lottoNumber) {
        int number = Integer.parseInt(lottoNumber);
        if (MIN_LOTTO_NUMBER > number || number > MAX_LOTTO_NUMBER) {
            String rangeMessage = String.format("(범위 : %d ~ %d)", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + OUT_OF_RANGE_MESSAGE + rangeMessage);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
