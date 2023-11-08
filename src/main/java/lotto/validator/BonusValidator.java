package lotto.validator;

import java.util.List;

public class BonusValidator extends Validator {

    public static int validateBonusNumber(String bonusNumbered) {
        int bonusNumber = parseBonusNumber(bonusNumbered);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static int parseBonusNumber(String bonusNumberStr) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberStr.trim());
            return bonusNumber;
        } catch (NumberFormatException e) {
            throwException("보너스 번호는 한 개의 숫자로만 입력해야 합니다.", e);
            return -1;
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throwException("보너스 번호는 1에서 45 사이의 숫자여야 합니다.", null);
        }
    }

}
