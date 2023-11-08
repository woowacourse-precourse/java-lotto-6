package lotto.common;

public class ExceptionHandler {

    public static void throwIllegalArgumentException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.getMessage());
    }

}
