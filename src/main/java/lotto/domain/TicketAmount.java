package lotto.domain;

import lotto.util.Validator;

public class TicketAmount {
    private final int amount;

    public TicketAmount(String money) {
        validate(money);
    }

    private static void validate(String money) {
        Validator.validateInputNotEmpty(money);
    }
}
