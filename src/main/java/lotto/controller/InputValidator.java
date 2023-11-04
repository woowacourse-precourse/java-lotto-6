package lotto.controller;

public class InputValidator {
    private static void inputIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비었습니다.");
        }
    }

    private static void isInteger(String input) {
        inputIsBlank(input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수 범위를 벗어났습니다.");
        }
    }

    private static void isThousandUnit(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이며, 1000원 단위여야 합니다.");
        }
    }

    public static boolean validatePurchaseAmount(String input) {
        isInteger(input);
        isThousandUnit(input);
        return true;
    }

    public static void validateCommaSeparated(String input) {
        if (!input.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 하며, 쉼표로 구분되어야 합니다.");
        }
    }

}
