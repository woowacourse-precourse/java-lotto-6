package lotto.processor;

import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.ViewFacade;

public class InputProcessor<T> {
    private final InputParser<T> parser;
    private final InputValidator<T> validator;
    private final ViewFacade viewFacade;

    public InputProcessor(InputParser<T> parser, InputValidator<T> validator,ViewFacade viewFacade) {
        this.parser = parser;
        this.validator = validator;
        this.viewFacade = viewFacade;
    }

    public T process() {
        String input = viewFacade.ask();
        while (true) {
            try {
                T parsedInput = parser.parse(input);
                validator.validate(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException e) {
                input = viewFacade.errorAndAsk(e.getMessage());
            }
        }
    }
}
