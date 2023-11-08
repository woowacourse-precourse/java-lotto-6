package validator;

public class WinningNumbersValidator {
    public static void winningNumbersValidate(String winningNumbers) {
        winningNumbersNotNull(winningNumbers);
    }

    private static void winningNumbersNotNull(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
