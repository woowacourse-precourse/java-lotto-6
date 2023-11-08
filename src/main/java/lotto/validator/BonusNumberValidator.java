package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusNumberValidator extends Validator {
    private static final Pattern VALID_NUMBER_REGEXP = Pattern.compile("[0-9]+");

    @Override
    public void validate(String bonusNumber) {
        validateEmptyInput(bonusNumber);
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        if(!isValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        Matcher matcher = VALID_NUMBER_REGEXP.matcher(bonusNumber);
        return matcher.matches();
    }

    public static void validateBonusNumberBound(int bonusNumber) {
        if(bonusNumber < LottoNumConstant.MIN_LOTTO_NUMBER_BOUND.getValue() || bonusNumber > LottoNumConstant.MAX_LOTTO_NUMBER_BOUND.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_BOUND_ERROR.getMessage());
        }
    }

    public static void validateContainBonusNumInWinningLotto(List<Integer> winningLotto, int bonusNumber) {
        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLE_BONUS_NUM_TO_WINNING_NUM.getMessage());
        }
    }
}
