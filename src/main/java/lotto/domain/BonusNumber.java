package lotto.domain;

import static lotto.exception.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.ErrorMessage.INVALID_RANGE;
import static lotto.validator.InputValidator.validateEmpty;
import static lotto.validator.InputValidator.validateNumber;

import java.util.List;
import lotto.exception.LottoException;

public class BonusNumber {

    private static int bonusNumber;
    public static int bonusNumber(String input, List<Integer> winningNumbers){
        validateEmpty(input);
        validateNumber(input);

        int bonusNumber = Integer.parseInt(input);
        validateRange(bonusNumber);
        validateDuplicateNumbers(winningNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void validateRange(int bonusNumber) {
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw LottoException.of(INVALID_RANGE);
            }

    }

    private static void validateDuplicateNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw LottoException.of(DUPLICATE_BONUS_NUMBER);
        }
    }

}
