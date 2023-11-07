package lotto.model;

import java.util.regex.Matcher;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;
import lotto.utils.Converter;

public class Money {
    private final Integer amount;

    public Money(String amount) {
        validatePositiveAnd1000Units(amount);

        this.amount = Converter.stringToInteger(amount);
    }

    private void validatePositiveAnd1000Units(String number) {
        Matcher positiveAndStep1000 = Constant.PATTERN_POSITIVE_NUMBER_AND_1000_UNITS.matcher(number);

        if (positiveAndStep1000.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_MUST_POSITIVE_NUMBER_AND_1000_UNITS.getMessage());
        }
    }

    public Float calculateReturnRate(Integer earn) {
        Float result = Converter.integerToFloat(earn) / Converter.integerToFloat(amount) * Constant.NUMBER_USED_TO_MAKE_PERCENTAGE.getContentToFloat();
        Integer offsetNumber = Constant.NUMBER_USED_TO_ROUND_FIRST_DIGIT.getContentToInteger();

        return Math.round(result * offsetNumber) / Converter.integerToFloat(offsetNumber);
    }
}
