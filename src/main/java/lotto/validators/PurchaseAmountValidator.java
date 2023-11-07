package lotto.validators;

public class PurchaseAmountValidator {

    public static void validateType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!isNumeric(inputValue.charAt(i))) {
                System.out.println("[ERROR] 구입금액은 숫자!\n");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateUnit(String inputValue) {
        if (Integer.parseInt(inputValue) % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위!\n");
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
