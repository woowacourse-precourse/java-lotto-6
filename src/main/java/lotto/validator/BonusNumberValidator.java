package lotto.validator;

import static lotto.constants.Constants.BONUS_NOT_NUMBER_MSG;
import static lotto.constants.Constants.BONUS_NOT_VALID_RANGE_MSG;

public class BonusNumberValidator {
    public static boolean validate(String bonusNum) {
        if(isNumber(bonusNum));
        if(isValidNumber(bonusNum));
        return true;
    }

    public static boolean isNumber(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NOT_NUMBER_MSG);
        }
        return true;
    }
    public static boolean isValidNumber(String bonusNum) {
        if(Integer.parseInt(bonusNum)<0 || 56<Integer.parseInt(bonusNum)) {
            throw new IllegalArgumentException(BONUS_NOT_VALID_RANGE_MSG);
        }
        return true;
    }
}
