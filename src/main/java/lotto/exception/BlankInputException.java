package lotto.exception;

public class BlankInputException extends IllegalArgumentException {

    public BlankInputException() {
        super("[ERROR] 입력이 비었습니다.");
    }
}
