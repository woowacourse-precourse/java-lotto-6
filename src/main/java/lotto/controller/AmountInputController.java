package lotto.controller;

import lotto.domain.vo.TotalAmount;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AmountInputController {
    private final InputParser<Integer> amountParser;
    private final InputValidator<Integer> validator;

    public AmountInputController(InputParser<Integer> amountParser, InputValidator<Integer> validator) {
        this.amountParser = amountParser;
        this.validator = validator;
    }

    public TotalAmount InputValid() {
        while (true) {
            try {
                String input = readInput();
                Integer amount = parseInput(input);
                validateAmount(amount);
                return createTotalAmount(amount);
            } catch (IllegalArgumentException e) {
                displayError(e.getMessage());
            }
        }
    }

    private String readInput() {
        return InputView.readAmount();
    }

    private Integer parseInput(String input) {
        return amountParser.parse(input);
    }

    private void validateAmount(Integer amount) {
        validator.validate(amount);
    }

    private TotalAmount createTotalAmount(Integer amount) {
        return TotalAmount.from(amount);
    }

    private void displayError(String message) {
        OutputView.printError(message);
    }
}
