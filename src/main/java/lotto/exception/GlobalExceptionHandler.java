package lotto.exception;

public class GlobalExceptionHandler {
    private static final String errorInitialCode = "[ERROR] ";
    public static void handleCustomException(CustomException e){
        ErrorCode errorCode = e.getErrorCode();
        Class className = errorCode.getExceptionClass();

        if(className == IllegalArgumentException.class){
            throw new IllegalArgumentException(errorInitialCode+errorCode.getMessage());
        }
        if(className == IllegalStateException.class){
            throw new IllegalStateException(errorInitialCode+errorCode.getMessage());
        }

    }
}
