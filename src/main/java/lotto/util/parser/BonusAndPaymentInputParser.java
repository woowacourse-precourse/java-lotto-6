package lotto.util.parser;

import static lotto.ErrorMessage.BONUS_AND_PAYMENT_WRONG_INPUT_ERROR_MESSAGE;
import static lotto.ErrorMessage.PARSE_INT_ERROR_MESSAGE;
import static lotto.ErrorMessage.throwException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BonusAndPaymentInputParser extends InputParser {
    private static final Pattern PATTERN = Pattern.compile("^\\d+$");

    @Override
    public List<Integer> parse(String input) {
        input = removeSpaces(input);
        validate(input);
        return parseInt(input);
    }

    @Override
    public void validate(String input) {
        if (!isNumeric(input)) {
            throwException(BONUS_AND_PAYMENT_WRONG_INPUT_ERROR_MESSAGE.get());
        }
    }

    private boolean isNumeric(String input) {
        return PATTERN.matcher(input).matches();
    }

    private List<Integer> parseInt(String input) {
        List<Integer> result = new ArrayList<>();
        try {
            int value = Integer.parseInt(input);
            result.add(value);
        } catch (NumberFormatException e) {
            throwException(PARSE_INT_ERROR_MESSAGE.get());
        }
        return result;
    }
}
