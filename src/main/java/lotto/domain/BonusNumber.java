package lotto.domain;

import lotto.validator.LottoNumberValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(String input) {
        this.number = validate(input);
    }

    public static BonusNumber create(String input) {
        return new BonusNumber(input);
    }

    private int validate(String input) {
        int number = LottoNumberValidator.validateNumeric(input);
        LottoNumberValidator.validateRange(number);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
