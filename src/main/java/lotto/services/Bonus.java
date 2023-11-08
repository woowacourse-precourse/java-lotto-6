package lotto.services;

import static lotto.exception.ExceptionHandler.noLengthOfOne;
import static lotto.exception.ExceptionHandler.notBetween1And45;
import static lotto.utils.Utils.is1And45;
import static lotto.utils.Utils.stringToInteger;

public class Bonus {

    public int createBonusNumber(String bonus) {
        validateBonusLength(bonus);
        validateBonusRange(bonus);

        return stringToInteger(bonus);
    }

    private void validateBonusRange(String bonus) {
        int convert = stringToInteger(bonus);

        if (!is1And45(convert)) {
            notBetween1And45();
        }
    }

    private void validateBonusLength(String bonus) {
        int length = bonus.length();
        if (length > 2) {
            noLengthOfOne();
        }
    }
}
