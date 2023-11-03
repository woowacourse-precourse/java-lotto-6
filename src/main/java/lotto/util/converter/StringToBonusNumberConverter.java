package lotto.util.converter;

import lotto.domain.BonusNumber;
import lotto.util.ErrorMessage;

public class StringToBonusNumberConverter implements Converter<String, BonusNumber> {

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == BonusNumber.class;
    }

    @Override
    public BonusNumber convert(String target) {
        int number = toInt(target);
        return new BonusNumber(number);
    }

    private int toInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_ERROR.getMessage());
        }
    }
}
