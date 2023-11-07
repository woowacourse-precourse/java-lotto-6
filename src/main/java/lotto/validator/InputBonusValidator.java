package lotto.validator;

import lotto.exception.DuplicatedNumberException;
import lotto.exception.EmptyException;
import lotto.exception.InvalidLottoFormatException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.model.Lotto;

public class InputBonusValidator {
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private InputBonusValidator() {
    }
    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new EmptyException();
        }
    }
    public static void validateBonusNumberFormat(final String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new InvalidLottoFormatException();
        }
    }
    public static void validateBonusNumberRange(final String bonusNumber){
        int integerBonusNumber = Integer.parseInt(bonusNumber);
        if(integerBonusNumber < START_NUMBER || integerBonusNumber > END_NUMBER){
            throw new InvalidLottoNumberRangeException();
        }
    }
    public static void validateBonusInLotto(final Lotto winningLotto, final String input) {
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
