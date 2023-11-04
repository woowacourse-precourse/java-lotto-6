package lotto.domain;

import static lotto.util.Validator.validateDuplicateLotto;
import static lotto.util.Validator.validateNonNumeric;
import static lotto.util.Validator.validateRange;

public class BonusNumber {
    private final String number;

    public BonusNumber(String number, Lotto lotto) {
        validateNonNumeric(number);
        validateRange(Integer.parseInt(number));
        validateDuplicateLotto(Integer.parseInt(number), lotto);
        this.number = number;
    }

    public String getBonusNumber() {
        return number;
    }
}
