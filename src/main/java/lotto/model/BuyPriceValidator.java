package lotto.model;

import java.util.regex.Matcher;
import lotto.utils.Constants;

public class BuyPriceValidator {
    private String buyPrice;

    public BuyPriceValidator(String buyPrice) {
        this.buyPrice = buyPrice;
        validate();
    }

    private void validate(){
        isNumber();
    }

    public void isNumber(){
        Matcher matcher = Constants.BUY_PRICE_PATTERN.matcher(buyPrice);
        if(!matcher.find()){
            throw new IllegalArgumentException(Constants.ERROR_MESSAGE + Constants.BUY_PRICE_PATTERN_ERROR);
        }
    }

}
