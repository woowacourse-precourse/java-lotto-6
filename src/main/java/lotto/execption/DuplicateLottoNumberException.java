package lotto.execption;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 당첨 번호를 입력하였습니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
