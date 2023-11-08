package errorhandler;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    private InputException inputException;

    public CustomIllegalArgumentException(InputException inputExceptionEnum) {
        super(inputExceptionEnum.getMessage());
        this.inputException = inputExceptionEnum;
    }

    public InputException getError() {
        return inputException;
    }

}
