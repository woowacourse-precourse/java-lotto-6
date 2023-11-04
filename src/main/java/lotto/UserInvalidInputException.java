package lotto;

import static lotto.StringResourceProvider.ERROR_MESSAGE_TAG;

public class UserInvalidInputException extends IllegalArgumentException{
    UserInvalidInputException(String message){
        super(message);
    }
    UserInvalidInputException(String message, Throwable cause){
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return String.format("%s %s",ERROR_MESSAGE_TAG,  super.getMessage());
    }
}
