package lotto.validator;

import java.util.List;

public class BonusNumberValidator {
    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;

    public static void validateBonusNumber(List<Integer> winNumbers, String input) throws IllegalArgumentException {
        validateBonusNumberNotNumber(input);

        Integer bonusNumber = Integer.parseInt(input);
        validateBonusNumberOutOfRange(bonusNumber);
        validateBonusNumberDuplicateWithWinNumbers(winNumbers, bonusNumber);
    }

    private static void validateBonusNumberNotNumber(String input) throws IllegalArgumentException {
        if (!ValidationUtil.isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateBonusNumberOutOfRange(Integer input) throws IllegalArgumentException {
        if (input < BONUS_NUMBER_MIN || input > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자 범위는 (1~45) 이내에 존재해야 합니다.");
        }
    }

    private static void validateBonusNumberDuplicateWithWinNumbers(List<Integer> winNumbers, Integer input) {
        if (winNumbers.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호 6개와 중복되면 안됩니다.");
        }
    }
}
