package lotto.model.domain.exception;

public class InputException extends Exception {

    private InputException() {

    }

    public static void inputNumberException() {
        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
    }
}
