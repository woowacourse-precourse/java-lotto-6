package lotto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;
import lotto.model.Constants;

public class PurchasePriceValidator {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile(ONLY_NUMBER_REGEX);

    public void validate(String purchasePrice) {
        purchasePrice = purchasePrice.replace(" ", "");
        validateOnlyNumber(purchasePrice);
        validateRange(Integer.parseInt(purchasePrice));
    }

    private void validateOnlyNumber(String purchasePrice) {
        Matcher matcher = ONLY_NUMBER_PATTERN.matcher(purchasePrice);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NO_NUMBER_EXCEPTION.getMessage());
        }
    }

    private void validateRange(int purchasePrice) {
        if (purchasePrice % Constants.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_UNIT_EXCEPTION.getMessage());
        }
    }
}
