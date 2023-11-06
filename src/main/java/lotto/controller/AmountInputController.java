package lotto.controller;

import lotto.domain.vo.TotalAmount;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.AmountViewFacade;

public class AmountInputController implements InputController<TotalAmount> {
    private final InputParser<Integer> parser;
    private final InputValidator<Integer> validator;

    public AmountInputController(InputParser<Integer> parser, InputValidator<Integer> validator) {
        this.parser = parser;
        this.validator = validator;
    }

    @Override
    public TotalAmount inputValid() {
        String input = AmountViewFacade.ask();
        while (true) {
            try {
                int amount =  parser.parse(input);
                return TotalAmount.of(amount, validator);
            } catch (IllegalArgumentException e) {
                input = AmountViewFacade.errorAndAsk(e.getMessage());
            }
        }
    }
}
