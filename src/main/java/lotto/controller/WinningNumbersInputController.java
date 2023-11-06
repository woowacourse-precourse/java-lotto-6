package lotto.controller;

import java.util.List;
import lotto.domain.vo.WinningNumbers;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.WinningNumbersViewFacade;

public class WinningNumbersInputController implements InputController<WinningNumbers> {
    private final InputParser<List<Integer>> parser;
    private final InputValidator<List<Integer>> validator;

    public WinningNumbersInputController(InputParser<List<Integer>> parser, InputValidator<List<Integer>> validator) {
        this.parser = parser;
        this.validator = validator;
    }

    @Override
    public WinningNumbers inputValid() {
        String input = WinningNumbersViewFacade.ask();
        while (true) {
            try {
                List<Integer> numbers = parser.parse(input);
                return WinningNumbers.of(numbers, validator);
            } catch (IllegalArgumentException e) {
                input = WinningNumbersViewFacade.errorAndAsk(e.getMessage());
            }
        }
    }
}
