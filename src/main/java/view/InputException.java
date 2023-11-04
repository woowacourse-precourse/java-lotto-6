package view;

public class InputException {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String CAN_BE_CONVERTED_TO_INTEGER_MESSAGE = "입력하신 값이 숫자가 아닙니다.";

    public static void canBeConvertedToInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAN_BE_CONVERTED_TO_INTEGER_MESSAGE);
        }
    }
}
