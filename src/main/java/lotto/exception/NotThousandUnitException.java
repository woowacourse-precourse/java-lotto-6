package lotto.exception;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class NotThousandUnitException extends IllegalArgumentException {
    public NotThousandUnitException() {
        super(String.format(ErrorMessage.NOT_THOUSAND_UNIT_ERROR.getMessage(), LottoRule.MONEY_UNIT));
    }
}
