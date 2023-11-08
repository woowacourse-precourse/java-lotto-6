package lotto.exception;

public class InvalidDuplicatedNumberException extends IllegalArgumentException {

    private static final String INVALID_DUPLICATED_NUMBER_MESSAGE = "[ERROR] 로또 숫자 중 중복된 값이 있습니다.";

    public InvalidDuplicatedNumberException() {
        super(INVALID_DUPLICATED_NUMBER_MESSAGE);
    }
}
