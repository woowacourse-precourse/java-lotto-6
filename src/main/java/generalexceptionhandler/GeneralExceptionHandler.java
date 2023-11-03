package generalexceptionhandler;

public class GeneralExceptionHandler {

    public static final String EMPTY_ERROR_MESSAGE = "[ERROR] 구매금액이 1000원 미만입니다.";

    public static int numberExceptionHandler(String inputStr) {
        isNotEmpty(inputStr);
        return 1;
    }

    public static void isNotEmpty(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }
}
