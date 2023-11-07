package lotto.validators;

import lotto.utils.NumericUtil;

import java.util.Arrays;
import java.util.HashSet;

public class WinningNumbersValidator {

    public static void validateLength(String[] inputValues) {
        if (inputValues.length != 6) {
            System.out.println("[ERROR] 당첨 번호는 총 6개!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateType(String[] inputValues) {
        for (int i = 0; i < inputValues.length; i++) {
            if (!NumericUtil.isNumeric(inputValues[i].charAt(0))) {
                System.out.println("[ERROR] 당첨 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(String[] inputValues) {
        for (int i = 0; i < inputValues.length; i++) {
            if (Integer.parseInt(inputValues[i]) < 0 || 45 < Integer.parseInt(inputValues[i])) { // 범위
                System.out.println("[ERROR] 당첨 번호는 1이상 45이하!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateDuplicate(String[] inputValues) {
        HashSet<String> set = new HashSet<>(Arrays.stream(inputValues).toList());
        if (set.size() < 6) { // 중복
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없음!");
            throw new IllegalArgumentException();
        }
    }
}
