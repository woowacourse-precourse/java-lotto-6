package util;

public class Validator {
    private Validator() {
    }

    public static void validateTicketPurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 잘못된 값을 입력했습니다.");
        } else if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
