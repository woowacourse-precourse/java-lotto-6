package view;

public class InputException {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String CAN_BE_CONVERTED_TO_INTEGER_MESSAGE = "입력하신 값이 숫자가 아닙니다.";
    public static final int PURCHASE_AMOUNT_UNIT = 1000;
    public static final int ZERO = 0;
    public static final String IS_VALID_AMOUNT_MESSAGE = "로또 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public static void canBeConvertedToInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CAN_BE_CONVERTED_TO_INTEGER_MESSAGE);
        }
    }

    public static void isValidAmount(String userInput) {
        int amount = Integer.parseInt(userInput);
        if (amount % PURCHASE_AMOUNT_UNIT > ZERO) {
            throw new IllegalArgumentException(ERROR_MESSAGE + IS_VALID_AMOUNT_MESSAGE);
        }
    }
}
