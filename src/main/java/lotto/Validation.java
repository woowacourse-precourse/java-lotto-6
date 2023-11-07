package lotto;

import java.util.List;

public class Validation {
    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isAllValidNumbers(List<String> original) {
        for (String previous : original) {
            int num = Integer.parseInt(previous);
            validateNumberRange(num);
        }
    }

    public static void validateNumberRange(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(int num, List<String> winningNums) {
        validateNumberRange(num);
        if (winningNums.contains(Integer.toString(num))) {
            throw new IllegalArgumentException();
        }
    }
}
