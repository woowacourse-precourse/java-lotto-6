package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.utils.ErrorMessage;

public class InputView {
    public PurchaseAmout getPurchaseAmout() {
        String input = Console.readLine();
        validateNotNull(input);
        validateNotEmpty(input);
        validateParsedToInteger(input);
        return new PurchaseAmout(Integer.parseInt(input));
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    private void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateParsedToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }
}
