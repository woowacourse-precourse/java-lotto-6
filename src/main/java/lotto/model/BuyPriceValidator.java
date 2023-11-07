package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.utils.ErrorMessage;
import lotto.utils.Patterns;
import lotto.view.InputView;

public class BuyPriceValidator {
    private String buyPrice;

    public BuyPriceValidator(String buyPrice) {
        this.buyPrice = buyPrice;
        validate();
    }

    private void validate() {
        isNumber();
        isCorrectUnit();
    }

    public void isNumber() {
        Matcher matcher = Pattern.compile(Patterns.BUY_PRICE_PATTERN.getPattern()).matcher(buyPrice);
        if (!matcher.find()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.BUY_PRICE_PATTERN_ERROR.getMessage());
        }
    }

    public void isCorrectUnit() {
        int price = InputView.convertToInt(buyPrice);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_MESSAGE.getMessage() + ErrorMessage.BUY_PRICE_UNIT_ERROR.getMessage());
        }
    }
}
