package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusNumberValidator extends Validator {
    private static final Pattern VALID_NUMBER_REGEXP = Pattern.compile("[0-9]+");

    @Override
    public void validate(String bonusNumber) throws IllegalArgumentException {
        validateEmptyInput(bonusNumber);
        validateBonusNumber(bonusNumber);
        validateBonusNumberBound(Integer.parseInt(bonusNumber));
    }

    private void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        if(!isValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        Matcher matcher = VALID_NUMBER_REGEXP.matcher(bonusNumber);
        return matcher.matches();
    }

    private void validateBonusNumberBound(int bonusNumber) throws IllegalArgumentException {
        if(bonusNumber < LottoNumConstant.MIN_LOTTO_NUMBER_BOUND.getValue() || bonusNumber > LottoNumConstant.MAX_LOTTO_NUMBER_BOUND.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_BOUND_ERROR.getMessage());
        }
    }
}
