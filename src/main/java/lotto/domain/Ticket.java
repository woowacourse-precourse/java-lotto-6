package lotto.domain;

import lotto.constant.ExceptionMessage;

public class Ticket {

    private final Integer value;

    public Ticket(final Integer value) {
        this.value = value;
    }

    public Integer toValue() {
        validateNullTicket(value);
        return value;
    }

    public void validateNullTicket(final Integer value) {
        if (value == null) {
            throw new IllegalStateException(ExceptionMessage.INVALID_NULL.toMessage());
        }
    }
}
