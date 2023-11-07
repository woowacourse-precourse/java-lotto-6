package lotto.exception;

public class UserBuyingException {
    public void validateBuyingException(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }
}
