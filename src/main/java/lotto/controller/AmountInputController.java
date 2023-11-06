package lotto.controller;

import lotto.domain.vo.TotalAmount;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AmountInputController implements InputController<TotalAmount> {
    private final InputParser<Integer> parser;
    private final InputValidator<Integer> validator;

    public AmountInputController(InputParser<Integer> parser, InputValidator<Integer> validator) {
        this.parser = parser;
        this.validator = validator;
    }

    @Override
    public TotalAmount inputValid() {
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
        return parser.parse(input);
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
