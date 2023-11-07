package lotto.validators;

public class BonusNumberValidator {

    public static void validateType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!isNumeric(inputValue.charAt(i))) {
                System.out.println("[ERROR] 보너스 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(String inputValue) {
        if (1 > Integer.parseInt(inputValue) || 45 < Integer.parseInt(inputValue)) {
            System.out.println("[ERROR] 보너스 번호는 1이상 45이하!");
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(char c) {
        if (!Character.isDigit(c)) {
            return false;
        }
        return true;
    }
}
