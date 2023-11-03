package generalexceptionhandler;

public class GeneralExceptionHandler {

    public static final String EMPTY_ERROR_MESSAGE = "[ERROR] 입력한 값이 존재하지 않습니다.";

    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 값이 숫자가 아닙니다.";

    public static int numberExceptionHandler(String inputStr) {
        checkEmpty(inputStr);
        return checkNumber(inputStr);
    }

    public static void checkEmpty(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static int checkNumber(String inputStr) {
        try {
            int returnNumber = Integer.parseInt(inputStr);
            return returnNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
