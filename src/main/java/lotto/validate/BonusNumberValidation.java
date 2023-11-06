package lotto.validate;

import java.util.regex.Pattern;

public class BonusNumberValidation implements LottoValidation {
    @Override
    public boolean validate(final String userInput) {
        return Pattern.matches("^(?:[1-9]|[1-3][0-9]|4[0-5])$", userInput);
    }
}
