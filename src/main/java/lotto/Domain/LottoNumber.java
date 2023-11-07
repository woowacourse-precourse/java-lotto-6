package lotto.Domain;

import lotto.Constant.Constant;

public class LottoNumber {
    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닌 값이 들어있습니다.";
    private final int lottoNumber;

    public LottoNumber(String lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validate(String lottoNumber) {
        if(!lottoNumber.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + NOT_NUMBER_MESSAGE);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
