package lotto.validator;

import java.util.List;
import lotto.Constant.ErrorMessage;

public class BonusNumberValidator {

    public static int validate(String input) {
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            validateRange(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
        }
    }

    public static int validate(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateBonusNumberNotInLottoNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateRange(int number) {
        if (!LottoNumberValidator.isNumberInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    private static void validateBonusNumberNotInLottoNumbers(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
}
