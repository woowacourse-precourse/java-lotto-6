package lotto.controller;

import lotto.domain.vo.TotalAmount;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.ViewFacade;

public class AmountInputController implements InputController<TotalAmount> {
    private final InputParser<Integer> parser;
    private final InputValidator<Integer> validator;
    private final ViewFacade viewFacade;

    public AmountInputController(InputParser<Integer> parser, InputValidator<Integer> validator, ViewFacade viewFacade) {
        this.parser = parser;
        this.validator = validator;
        this.viewFacade = viewFacade;
    }

    @Override
    public TotalAmount inputValid() {
        String input = viewFacade.ask();
        while (true) {
            try {
                int amount =  parser.parse(input);
                return TotalAmount.of(amount, validator);
            } catch (IllegalArgumentException e) {
                input = viewFacade.errorAndAsk(e.getMessage());
            }
        }
    }
}
