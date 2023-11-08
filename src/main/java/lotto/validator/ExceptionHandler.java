package lotto.validator;

public class ExceptionHandler {
    public static void illegalArgument(String errorMessage){
        throw new IllegalArgumentException(errorMessage);
    }
}
