package lotto.controller;

import lotto.domain.TicketAmount;
import lotto.util.Validator;
import lotto.view.InputView;

public class InputController {
    public TicketAmount setTicketAmount() {
        try {
            String input = InputView.inputMoney();
            validateInput(input);
            return new TicketAmount(input);
        } catch (IllegalArgumentException e) {
            return setTicketAmount();
        }
    }

    private void validateInput(String input) {
        Validator.validateInputNotEmpty(input);
        Validator.validateIsParsableToInt(input);
    }
}
