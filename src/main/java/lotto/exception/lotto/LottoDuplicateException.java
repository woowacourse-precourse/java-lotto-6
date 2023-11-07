package lotto.exception.lotto;

public class LottoDuplicateException extends IllegalArgumentException {
    private static final String DUPLICATE_NUMBER = "중복된 숫자가 존재합니다.";

    public LottoDuplicateException() {
        super(DUPLICATE_NUMBER);
    }
}
