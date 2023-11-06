package lotto.model;

import static lotto.utils.Constants.BUY_PRICE_PATTERN;
import static lotto.utils.Constants.BUY_PRICE_PATTERN_ERROR;
import static lotto.utils.Constants.BUY_PRICE_UNIT_ERROR;
import static lotto.utils.Constants.ERROR_MESSAGE;

import java.util.regex.Matcher;
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
        Matcher matcher = BUY_PRICE_PATTERN.matcher(buyPrice);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BUY_PRICE_PATTERN_ERROR);
        }
    }

    public void isCorrectUnit() {
        int price = InputView.convertToInt(buyPrice);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BUY_PRICE_UNIT_ERROR);
        }
    }
}
