package lotto.view.exception;


public class InvalidDivision extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000 으로 나누어떨어지지 않음";

    public InvalidDivision() {
        super(ERROR_MESSAGE);
    }

}
