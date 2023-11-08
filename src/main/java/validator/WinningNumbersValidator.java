package validator;

public class WinningNumbersValidator {
    public static void winningNumbersValidate(String winningNumbers) {
        winningNumbersNotNull(winningNumbers);
        winningNumbersComma(winningNumbers);
    }

    private static void winningNumbersNotNull(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void winningNumbersComma(String money) {
        if (!money.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 쉼표로 구분해주세요.");
        }
    }
}
