package lotto.Validator;

public class InputValidator {
    public static final String ERROR = "[ERROR] ";
    public static final String CAN_NOT_DIVIDE_BY_1000 = "로또 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String NOT_A_NUMBER = "로또 구입 금액은 숫자로 입력하셔야합니다.";

    public static boolean checkDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + CAN_NOT_DIVIDE_BY_1000);
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        if (!str.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR + NOT_A_NUMBER);
        }
        return true;
    }
}
