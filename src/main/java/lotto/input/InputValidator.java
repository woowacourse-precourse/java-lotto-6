package lotto.input;

public class InputValidator {
    public static void isValidPurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        isNotEmpty(purchaseAmount);
        isNumber(purchaseAmount);
        isMultipleOfThousand(purchaseAmount);
    }

    public static void isValidWinningNumbers(String[] winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String number : winningNumbers) {
            isNotEmpty(number);
            isNumber(number);
        }
    }

    private static void isNotEmpty(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 있어야 합니다.");
        }
    }

    private static void isNumber(String input) {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static void isMultipleOfThousand(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void isValidRange(String input) {
        if (!(1 <= Integer.parseInt(input) && Integer.parseInt(input) <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
