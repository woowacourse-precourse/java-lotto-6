package lotto.exception;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static void validatePurchaseAmount(String amount) {
        int num = validateDisit(amount);
        validatePurchaseAmountMultipleOf1000(num);
        validatePurchaseAmountMinimumValue(num);
        validatePurchaseAmountMaximumValue(num);
    }

    public static void validateWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        HashSet<Integer> duplicateSet = new HashSet<>();

        validateWinningNumbersCount(numbers);

        for (String number : numbers) {
            int num = validateDisit(number);
            validateNumberRange(num);
            duplicateSet.add(num);
        }
        validateUniqueWinningNumbers(duplicateSet);
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        int num = validateDisit(bonusNumber);

        validateNumberRange(num);
        validateNoDuplicateBonusNumber(num, winningNumbers);
    }

    private static void validatePurchaseAmountMultipleOf1000(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmountMinimumValue(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void validatePurchaseAmountMaximumValue(int amount) {
        if (amount >= Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException("[ERROR] 2,100,000,000 이하의 값만 입력 가능합니다.");
        }
    }

    private static int validateDisit(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능 합니다.");
        }
    }

    private static void validateWinningNumbersCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개로 입력해야 합니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateUniqueWinningNumbers(HashSet<Integer> duplicateSet) {
        if (duplicateSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 불가능합니다.");
        }
    }

    private static void validateNoDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}