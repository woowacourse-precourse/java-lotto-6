package lotto.input;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void isValidPurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        isNotEmpty(purchaseAmount);
        isNumber(purchaseAmount);
        isMultipleOfThousand(purchaseAmount);
    }

    public static void isValidWinningNumbers(String[] winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.length == 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 있어야 합니다.");
        }
        for (String number : winningNumbers) {
            isNotEmpty(number);
            isNumber(number);
            isValidRange(number);
        }
    }

    public static void isValidWinningNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
        Set<Integer> winningNumberSet = new HashSet<>(winningNumbers);
        if (winningNumberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public static void isValidBonusNumber(String bonusNumber) throws IllegalArgumentException {
        isNotEmpty(bonusNumber);
        isNumber(bonusNumber);
        isValidRange(bonusNumber);
    }

    private static void isNotEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 있어야 합니다.");
        }
    }

    private static void isNumber(String input) throws IllegalArgumentException {
        if (!input.matches("[0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private static void isMultipleOfThousand(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void isValidRange(String input) throws IllegalArgumentException {
        if (!(1 <= Integer.parseInt(input) && Integer.parseInt(input) <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
