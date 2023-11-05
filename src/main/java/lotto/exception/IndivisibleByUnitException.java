package lotto.exception;

public class IndivisibleByUnitException extends IllegalArgumentException {
    public static final String ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.";
    public IndivisibleByUnitException() {
        super(ERROR_MESSAGE);
    }
}