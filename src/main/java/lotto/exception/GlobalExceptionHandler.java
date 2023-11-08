package lotto.exception;

public class GlobalExceptionHandler {

    public static void handleCustomException(CustomException e){
        ErrorCode errorCode = e.getErrorCode();
        Class className = errorCode.getExceptionClass();

        if(className == IllegalArgumentException.class){
            throw new IllegalArgumentException(errorCode.getMessage());
        }
        if(className == IllegalStateException.class){
            throw new IllegalStateException(errorCode.getMessage());
        }

    }
}
