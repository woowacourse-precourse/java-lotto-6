package lotto.exception;

import static lotto.resource.TextResourceProvider.ERROR_MESSAGE_TAG;

public class UserInvalidInputException extends IllegalArgumentException {

    private String invalidInput;

    public UserInvalidInputException(Throwable cause) {
        super(cause);
        this.invalidInput = "";
    }

    public UserInvalidInputException(String message, String invalidInput) {
        super(message);
        this.invalidInput = invalidInput;
    }

    public UserInvalidInputException(String message, String invalidInput, Throwable cause) {
        super(message, cause);
        this.invalidInput = invalidInput;
    }

    @Override
    public String getMessage() {
        return String.format("%s : %s ", super.getMessage(), invalidInput);
    }
}
