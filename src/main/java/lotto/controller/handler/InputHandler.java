package lotto.controller.handler;

import lotto.controller.converter.Converter;
import lotto.controller.validator.Validator;

public abstract class InputHandler<T> {
    protected Converter<T> converter;
    protected Validator validator;
    protected String input;

    public void handle() {
        validator.validate(input);
    }

    public T getHandledResult() {
        return converter.convert(input);
    }
}
