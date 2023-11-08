package lotto.validation;

import java.util.List;
import lotto.enums.LottoConstants;
import lotto.enums.LottoErrorCodes;

public class BonusNumberValidator {

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
            throw new IllegalArgumentException(LottoErrorCodes.INVALID_INTEGER_INPUT.getMessage());
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < LottoConstants.MINIMUM_NUMBER.getValue() || number > LottoConstants.MAXIMUM_NUMBER.getValue()) {
            throw new IllegalArgumentException(LottoErrorCodes.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private static void validateNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorCodes.DIFFERENT_BONUS_NUMBER_ERROR.getMessage());
        }
    }


}
