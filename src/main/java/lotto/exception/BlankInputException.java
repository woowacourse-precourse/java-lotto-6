package lotto.exception;

public class BlankInputException extends IllegalArgumentException {

    public BlankInputException() {
        super("입력이 비었습니다.");
    }
}
