package lotto.domain;

import lotto.validator.LottoValidator;

public class BonusNumber {
    private final int number;

    private BonusNumber(String input) {
        this.number = validate(input);
    }

    public static BonusNumber create(String input) {
        return new BonusNumber(input);
    }

    private int validate(String input) {
        int number = LottoValidator.validateNumeric(input);
        LottoValidator.validateRange(number);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
