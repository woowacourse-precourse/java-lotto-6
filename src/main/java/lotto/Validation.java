package lotto;

import static lotto.ErrorMessage.*;

import java.util.regex.Pattern;

public class Validation {
    public void validateNumberType(String number) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException(NUMBER.getMessage());
        }
    }
}
