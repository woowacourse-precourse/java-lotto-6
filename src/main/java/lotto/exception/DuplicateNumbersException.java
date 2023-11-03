package lotto.exception;

public class DuplicateNumbersException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_DUPLICATE_NUMBERS = "[ERROR] 로또에 중복 숫자가 있으면 안됩니다.";

    public DuplicateNumbersException(){
        super(ERROR_MESSAGE_DUPLICATE_NUMBERS);
    }
}
