package lotto.exception;

public class InputException extends IllegalArgumentException{
    private final InputExceptionMessage message;

    public InputException(InputExceptionMessage message) {
        this.message = message;
        System.out.println(message.getMessage());
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }
}
