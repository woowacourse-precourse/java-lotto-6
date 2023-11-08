package lotto.exception;

import lotto.constants.lotto.LottoRule;
import lotto.constants.message.ErrorMessage;

public class NotThousandUnitException extends IllegalArgumentException {
    public NotThousandUnitException() {
        super(String.format(ErrorMessage.NOT_THOUSAND_UNIT_ERROR.getMessage(), LottoRule.MONEY_UNIT));
    }
}
