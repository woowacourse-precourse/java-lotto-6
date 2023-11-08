package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.utils.ErrorMessage;
import lotto.utils.Patterns;
import lotto.view.InputView;

public class BonusNumberValidator {
    private String bonusNumber;

    public BonusNumberValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void validate() {
        isNumber();
        isRange();
    }

    public void isNumber() {
        Matcher matcher = Pattern.compile(Patterns.LOTTO_NUMBER_PATTERN.getPattern()).matcher(bonusNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.BONUS_NUMBER_PATTERN_ERROR.getMessage());
        }
    }

    public void isRange() {
        int number = InputView.convertToInt(bonusNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }

}
