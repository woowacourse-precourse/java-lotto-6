package lotto.exception;

import lotto.constants.ErrorMessage;

public class NotThousandUnitException extends IllegalArgumentException {
    public NotThousandUnitException() {
        super(ErrorMessage.NOT_THOUSAND_UNIT_ERROR.getMessage());
    }
}
