package generalexception;

public class GeneralExceptionHandler {

    public static final String EMPTY_ERROR_MESSAGE = "[ERROR] 입력한 값이 존재하지 않습니다.";

    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력한 값이 숫자가 아닙니다.";

    public static int validateNumberExceptionHandler(String inputStr) {
        validateEmpty(inputStr);
        return validateNumber(inputStr);
    }

    public static void validateEmpty(String inputStr) {
        if (inputStr.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static int validateNumber(String inputStr) {
        try {
            int returnNumber = Integer.parseInt(inputStr);
            return returnNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
