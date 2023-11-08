package lotto.validators;

import lotto.utils.NumericUtil;

import java.util.Arrays;
import java.util.HashSet;

public class WinningNumbersValidator {

    public static void validateLength(String[] winningNumbers) {
        if (winningNumbers.length != 6) {
            System.out.println("[ERROR] 당첨 번호는 총 6개!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateType(String[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (!NumericUtil.isNumeric(winningNumbers[i].charAt(0))) {
                System.out.println("[ERROR] 당첨 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(String[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (Integer.parseInt(winningNumbers[i]) < 0 || 45 < Integer.parseInt(winningNumbers[i])) {
                System.out.println("[ERROR] 당첨 번호는 1이상 45이하!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicate(String[] winningNumbers) {
        HashSet<String> set = new HashSet<>(Arrays.stream(winningNumbers).toList());
        if (set.size() < 6) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없음!");
            throw new IllegalArgumentException();
        }
    }
}
