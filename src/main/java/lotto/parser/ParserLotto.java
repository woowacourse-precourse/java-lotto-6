package lotto.parser;

import lotto.validator.Validate;
import java.util.regex.Pattern;
import lotto.view.ErrorMessage;

public class ParserLotto {
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public static int lottoParser(String money) {
        Validate.moneyValidate(money);
        return Integer.parseInt(money);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(ErrorMessage.TYPE_ERROR.getMessage());
        }
    }
}
