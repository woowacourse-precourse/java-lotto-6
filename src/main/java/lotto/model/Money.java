package lotto.model;

import java.util.regex.Matcher;
import lotto.dto.MoneyDTO;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;
import lotto.utils.Converter;

public class Money {
    private final Integer amount;

    public Money(String amount) {
        amount = amount.strip();
        validatePositiveAnd1000Units(amount);

        this.amount = Converter.stringToInteger(amount);
    }

    private void validatePositiveAnd1000Units(String number) {
        Matcher positiveAndStep1000 = Constant.PATTERN_POSITIVE_NUMBER_AND_1000_UNITS.matcher(number);

        if (positiveAndStep1000.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_POSITIVE_NUMBER_AND_1000_UNITS.getMessage());
        }
    }

    public MoneyDTO createDTO() {
        return new MoneyDTO(amount);
    }
}
