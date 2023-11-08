package lotto.validators;

import lotto.utils.NumericUtil;

import java.util.Arrays;
import java.util.HashSet;

public class BonusNumberValidator {

    public static void validateType(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!NumericUtil.isNumeric(inputValue.charAt(i))) {
                System.out.println("[ERROR] 보너스 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(String inputValue) {
        if (1 > Integer.parseInt(inputValue) || 45 < Integer.parseInt(inputValue)) {
            System.out.println("[ERROR] 보너스 번호는 1이상 45이하!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(String inputValue, String[] winningNumbers) {
        HashSet<String> set = new HashSet<>(Arrays.stream(winningNumbers).toList());
        if(set.contains(inputValue)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없음!");
            throw new IllegalArgumentException();
        }
    }
}
