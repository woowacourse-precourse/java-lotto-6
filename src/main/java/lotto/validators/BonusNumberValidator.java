package lotto.validators;

import lotto.utils.NumericUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BonusNumberValidator {

    public static void validateType(String bonusNumber) {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (!NumericUtil.isNumeric(bonusNumber.charAt(i))) {
                System.out.println("[ERROR] 보너스 번호는 숫자만!");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRange(String bonusNumber) {
        if (1 > Integer.parseInt(bonusNumber) || 45 < Integer.parseInt(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 1이상 45이하!");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(String bonusNumber, List<String> winningNumbers) {
        HashSet<String> set = new HashSet<>(winningNumbers);
        if(set.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없음!");
            throw new IllegalArgumentException();
        }
    }
}
