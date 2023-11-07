package lotto.exception.lotto;

public class LottoFormatException extends IllegalArgumentException {
    private static final String LOTTO_FORMAT_MSG = "[1,2,3,4,5,6] 같은 형식으로 숫자만 입력해주세요.";

    public LottoFormatException() {
        super(LOTTO_FORMAT_MSG);
    }
}
