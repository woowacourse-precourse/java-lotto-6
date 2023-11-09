package lotto.exception;

public class EmptySpaceIncludeException extends IllegalArgumentException {
    public EmptySpaceIncludeException() {
        super(ExceptionMessage.EMPTY_SPACE_INCLUDE_ERROR.getMessage());
    }
}
