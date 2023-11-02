package lotto.exception.domain.lotto;

public class LottoDuplicateNumException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또에 중복된 번호가 존재합니다.";

    public LottoDuplicateNumException() {
        super(ERROR_MESSAGE);
    }
}
