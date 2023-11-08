package lotto.validator;

import lotto.exception.*;
import lotto.model.Lotto;

public class InputBonusValidator {
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private InputBonusValidator() {
    }

    private static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new EmptyException();
        }
    }

    private static void validateBonusNumberFormat(final String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new InvalidLottoFormatException();
        }
    }

    private static void validateBonusNumberRange(final String bonusNumber){
        int integerBonusNumber = Integer.parseInt(bonusNumber);
        if(integerBonusNumber < START_NUMBER || integerBonusNumber > END_NUMBER){
            throw new InvalidLottoNumberRangeException();
        }
    }

    private static void validateBonusInLotto(final Lotto winningLotto, final String input) {
        if (winningLotto.getNumbers().contains(Integer.parseInt(input))) {
            throw new DuplicatedNumberException();
        }
    }

    public static void validateBonus(final Lotto winningLotto, final String bonusNumber){
        validateEmpty(bonusNumber);
        validateBonusNumberFormat(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusInLotto(winningLotto, bonusNumber);
    }
}
