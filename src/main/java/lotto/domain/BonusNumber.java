package lotto.domain;

import lotto.validator.Validator;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        Validator.validateNumberRange(number);
    }

    public int match(Lotto lotto) {
        return (int) lotto.getStream()
                .filter(number::equals)
                .count();
    }

    public Integer getNumber() {
        return number;
    }
}
