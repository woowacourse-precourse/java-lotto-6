package lotto.exception;

public class DuplicateInputException extends IllegalArgumentException {
    private static final String DUPLICATE_MESSAGE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    public DuplicateInputException() {
        super(DUPLICATE_MESSAGE);
    }
}
