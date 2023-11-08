package lotto.validators;

import lotto.utils.NumericUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WinningNumbersValidator {

    public static void validateLength(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 총 6개!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateType(List<String> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (!NumericUtil.isNumeric(winningNumbers.get(i).charAt(0))) {
                System.out.println("[ERROR] 당첨 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(List<String> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (Integer.parseInt(winningNumbers.get(i)) < 0 || 45 < Integer.parseInt(winningNumbers.get(i))) {
                System.out.println("[ERROR] 당첨 번호는 1이상 45이하!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicate(List<String> winningNumbers) {
        HashSet<String> set = new HashSet<>(winningNumbers);
        if (set.size() < 6) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없음!");
            throw new IllegalArgumentException();
        }
    }
}
