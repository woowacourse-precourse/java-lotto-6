package lotto.vo;

import lotto.util.parser.AmountParser;
import lotto.util.parser.InputParser;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.InputValidator;

public class Purchase {
    private int amount;

    private Purchase(int amount) {
        this.amount = amount;
    }

    public static Purchase createFromInput(String input) {
        int amount = parseInputAmount(input);
        validateAmount(amount);
        return new Purchase(amount);
    }

    private static int parseInputAmount(String input) {
        InputParser<Integer> parser = new AmountParser();
        return parser.parse(input);
    }

    private static void validateAmount(int amount) {
        InputValidator<Integer> validator = new AmountValidator();
        validator.validate(amount);
    }
}
