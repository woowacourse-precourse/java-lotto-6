package lotto.util.converter;

import lotto.domain.LottoMoney;
import lotto.util.Validator;

import static lotto.util.ErrorMessage.*;

public class StringToLottoMoneyConverter implements Converter<String, LottoMoney> {

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == LottoMoney.class;
    }

    @Override
    public LottoMoney convert(String target) {
        int money = toInt(target);
        Validator.validateMoney(money);
        return new LottoMoney(money);
    }

    private int toInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR.getMessage());
        }
    }
}
