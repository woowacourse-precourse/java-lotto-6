package lotto.domain;

import lotto.util.Validator;

public class TicketAmount {
    private final int amount;

    public TicketAmount(String money) {
        validateInput(money);
        int purchaseAmount = Integer.parseInt(money);
    }

    private static void validateInput(String money) {
        Validator.validateInputNotEmpty(money);
        Validator.validateIsParsableToInt(money);
    }
}
