package lotto.controller;

import java.util.List;
import lotto.domain.vo.WinningNumbers;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbersInputController implements InputController<WinningNumbers> {
    private final InputParser<List<Integer>> parser;
    private final InputValidator<List<Integer>> validator;

    public WinningNumbersInputController(InputParser<List<Integer>> parser, InputValidator<List<Integer>> validator) {
        this.parser = parser;
        this.validator = validator;
    }

    @Override
    public WinningNumbers inputValid() {
        while (true) {
            try {
                String input = readInput();
                List<Integer> numbers = parseInput(input);
                validateNumbers(numbers);
                return createWinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                displayError(e.getMessage());
            }
        }
    }

    private String readInput() {
        return InputView.readWinningNumbers();
    }

    private List<Integer> parseInput(String input) {
        return parser.parse(input);
    }

    private void validateNumbers(List<Integer> numbers) {
        validator.validate(numbers);
    }

    private WinningNumbers createWinningNumbers(List<Integer> numbers) {
        return WinningNumbers.from(numbers);
    }

    private void displayError(String message) {
        OutputView.printError(message);
    }
}
