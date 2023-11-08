package validator;

import java.util.List;

public class WinningNumbersValidator {
    public static void winningNumbersValidate(String winningNumbers) {
        winningNumbersNotNull(winningNumbers);
        winningNumbersComma(winningNumbers);
        winningNumbersEndComma(winningNumbers);
        List<String> winningSixNumbers = List.of(winningNumbers.split(","));
        winningNumbersSix(winningSixNumbers);
        winningNumberNotNull(winningSixNumbers);
    }

    private static void winningNumbersNotNull(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void winningNumbersComma(String winningNumbers) {
        if (!winningNumbers.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 쉼표로 구분해주세요.");
        }
    }

    private static void winningNumbersEndComma(String winningNumbers) {
        if (winningNumbers.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표를 올바르게 사용해주세요");
        }
    }

    private static void winningNumbersSix(List<String> winningSixNumbers) {
        if (winningSixNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 양의 정수 6개를 입력해주세요.");
        }
    }

    private static void winningNumberNotNull(List<String> winningSixNumbers) {
        for (String winningNumber : winningSixNumbers) {
            if (winningNumber.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 쉼표를 올바르게 사용해주세요.");
            }
        }
    }
}
