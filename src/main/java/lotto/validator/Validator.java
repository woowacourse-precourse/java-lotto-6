package lotto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;
import lotto.model.Constants;

public abstract class Validator {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile(ONLY_NUMBER_REGEX);

    public abstract void validate(String input);

    String removeSpace(String input) {
        return input.replace(" ", "");
    }

    void validateOnlyNumber(String input) {
        Matcher matcher = ONLY_NUMBER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NO_NUMBER_EXCEPTION.getMessage());
        }
    }

    void validatePurchasePriceRange(int purchasePrice) {
        if (purchasePrice % Constants.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_UNIT_EXCEPTION.getMessage());
        }
    }

    void validateLottoRange(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_EXCEPTION.getMessage());
        }
    }
}
