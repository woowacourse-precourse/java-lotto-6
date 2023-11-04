package lotto.domain;

import static lotto.util.Validator.validateNonNumeric;
import static lotto.util.Validator.validateRange;

public class BonusNumber {
    private final String number;

    public BonusNumber(String number) {
        validateNonNumeric(number);
        validateRange(Integer.parseInt(number));
        this.number = number;
    }

    public String getBonusNumber() {
        return number;
    }
}
