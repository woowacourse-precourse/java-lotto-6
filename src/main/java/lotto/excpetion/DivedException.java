package lotto.excpetion;

import static lotto.excpetion.constant.ExceptionMessage.NOT_THOUSAND_PRICE;

public class DivedException extends IllegalArgumentException{
    public DivedException() {
        super(NOT_THOUSAND_PRICE.getMessage());
    }
}
