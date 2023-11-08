package lotto.view.input.error;

public class InputIllegalArgumentException extends IllegalArgumentException {

    public InputIllegalArgumentException(InputError inputError) {
        super(inputError.message);
    }

    public InputIllegalArgumentException(InputError inputError, int value) {
        super(String.format(inputError.message, value));
    }
}
