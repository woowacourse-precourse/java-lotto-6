package lotto.util.handler;

import java.util.function.Function;
import lotto.util.parser.InputParser;
import lotto.util.validator.InputValidator;
import lotto.view.facade.ViewFacade;

public class InputHandler<T> {
    private final InputParser<T> parser;
    private final InputValidator<T> validator;
    private final ViewFacade viewFacade;

    public InputHandler(InputParser<T> parser, InputValidator<T> validator, ViewFacade viewFacade) {
        this.parser = parser;
        this.validator = validator;
        this.viewFacade = viewFacade;
    }

    public static <T, R> R processInput(InputHandler<T> handler, Function<T, R> mapper) {
        T input = handler.tryInput();
        return mapper.apply(input);
    }

    private T tryInput() {
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
