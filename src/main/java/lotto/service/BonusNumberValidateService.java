package lotto.service;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.validator.BonusNumberValidator;

public class BonusNumberValidateService {
    public boolean validate(String input, List<Integer> winNumber) {
        if (numericValidate(input) && rangeValidate(input) && duplicationValidate(input, winNumber)) {
            return true;
        }
        return false;
    }

    private boolean numericValidate(String input) {
        try {
            BonusNumberValidator.isNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        return true;
    }

    private boolean rangeValidate(String input) {
        try {
            BonusNumberValidator.haveValidateRange(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_RANGE.getMessage());
            return false;
        }
        return true;
    }

    private boolean duplicationValidate(String input, List<Integer> winNumber) {
        try {
            BonusNumberValidator.haveDuplicateNumber(winNumber, input);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.HAVE_DUPLICATE_BONUS_NUMBER.getMessage());
            return false;
        }
        return true;
    }
}
