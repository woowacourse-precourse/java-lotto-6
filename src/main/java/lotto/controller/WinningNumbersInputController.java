package lotto.controller;

import java.util.List;
import lotto.domain.vo.WinningNumbers;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.ViewFacade;

public class WinningNumbersInputController implements InputController<WinningNumbers> {
    private final InputParser<List<Integer>> parser;
    private final InputValidator<List<Integer>> validator;
    private final ViewFacade viewFacade;

    public WinningNumbersInputController(InputParser<List<Integer>> parser, InputValidator<List<Integer>> validator, ViewFacade viewFacade) {
        this.parser = parser;
        this.validator = validator;
        this.viewFacade = viewFacade;
    }

    @Override
    public WinningNumbers inputValid() {
        String input = viewFacade.ask();
        while (true) {
            try {
                List<Integer> numbers = parser.parse(input);
                return WinningNumbers.of(numbers, validator);
            } catch (IllegalArgumentException e) {
                input = viewFacade.errorAndAsk(e.getMessage());
            }
        }
    }
}
