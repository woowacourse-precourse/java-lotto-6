package lotto.exception.input;

public class HasSpaceException extends IllegalArgumentException{
    private static final String ERROR_MSG = "[ERROR] 공백을 포함하면 안됩니다.";

    public HasSpaceException() {
        super(ERROR_MSG);
    }
}
