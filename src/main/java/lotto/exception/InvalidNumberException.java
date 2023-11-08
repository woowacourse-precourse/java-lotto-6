package lotto.exception;

public class InvalidNumberException extends IllegalArgumentException {

    public InvalidNumberException(final int number) {
        super("[ERROR]" + number + "은(는) 올바르지 않은 숫자입니다.");
    }
}
