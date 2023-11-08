package lotto.domain.exception.lottoException;

import lotto.view.ExceptionMessage;

public class LottoPriceUnitsException extends IllegalArgumentException {

    public LottoPriceUnitsException() {
        super(ExceptionMessage.LOTTO_PRICE_UNITS_EXCEPTION.getErrorMessage());
    }
}
