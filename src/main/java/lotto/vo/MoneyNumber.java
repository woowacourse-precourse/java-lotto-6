package lotto.vo;

import lotto.validator.MoneyValidator;

public record MoneyNumber(String value) {
    public MoneyNumber{
        MoneyValidator.validate(value);
    }

    @Override
    public String toString(){
        return value;
    }
}
