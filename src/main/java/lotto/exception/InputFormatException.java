package lotto.exception;

public class InputFormatException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 입력 형식이 잘못되었습니다. 번호는 쉼표(,)를 기준으로 입력해주세요";

    public InputFormatException() {
        super(MESSAGE);
    }
}
