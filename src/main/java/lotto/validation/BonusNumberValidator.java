package lotto.validation;

import java.util.List;

public class BonusNumberValidator {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public static int validateBonusNumber(String bonusNumberStr, List<Integer> winningNumbers) {
        int bonusNumber = parseToInt(bonusNumberStr);
        validateNumberInRange(bonusNumber);
        validateNotInWinningNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseToInt(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.", exception);
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + MINIMUM_NUMBER + "에서 " + MAXIMUM_NUMBER + " 사이어야 합니다: " + number);
        }
    }

    private static void validateNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다: " + bonusNumber);
        }
    }


}
