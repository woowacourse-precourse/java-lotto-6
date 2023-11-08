package util;

public class TicketPurchaseAmountValidator {
    private TicketPurchaseAmountValidator() {
    }

    public static void validateNumberFormat(String input) {
        if (!input.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 잘못된 값을 입력했습니다.");
        }
    }

    public static void validateDivisor(String divisor) {
        if (Integer.parseInt(divisor) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateNumberFormat(input);
        validateDivisor(input);
    }
}
