package lotto.validator;

import lotto.model.Lotto;
import lotto.utils.FormatUtils;
import lotto.utils.constant.Error;

import java.util.List;
import java.util.regex.Pattern;

public class BonusValidator {
    private static final Pattern BONUS_REGEX = Pattern.compile("^[0-9]+$");

    public static void validate(Lotto lotto, String inputBonusNumber) {
        validateNumeric(inputBonusNumber);
        int bonusNumber = FormatUtils.stringToInteger(inputBonusNumber);
        validateDuplicate(lotto.getNumbers(), bonusNumber);
        validateRange(bonusNumber);
    }

    private static void validateNumeric(String inputBonusNumber) {
        if (!BONUS_REGEX.matcher(inputBonusNumber).matches()) {
            throw new IllegalArgumentException(Error.ERROR_BONUS_NUMBER_NOT_INTEGER);
        }
    }

    private static void validateDuplicate(List<Integer> winningLottoNumbers, int bonusNumber) {
        if(winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    public static void validateRange(int inputBonusNumber) {
        if(inputBonusNumber < 1 || inputBonusNumber > 45) {
            throw new IllegalArgumentException(Error.ERROR_BONUS_NUMBER_RANGE);
        }
    }
}
