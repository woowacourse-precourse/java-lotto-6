package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(int number) {
        BonusNumberValidator.validateLottoNumberRange(number);
        this.number = number;
    }

    public static BonusNumber from(String input) {
        return new BonusNumber(Convertor.convertStringToInt(input));
    }

    public int getNumber() {
        return number;
    }
}
