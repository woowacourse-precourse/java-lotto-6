package lotto.exception;

import static lotto.exception.ExceptionMessage.NOT_THOUSAND_PRICE;

public class DivedException extends IllegalArgumentException{
    public DivedException() {
        super(NOT_THOUSAND_PRICE.getMessage());
    }
}
