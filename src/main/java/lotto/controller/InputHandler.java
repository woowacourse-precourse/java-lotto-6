package lotto.controller;

import lotto.controller.converter.Converter;
import lotto.controller.validator.Validator;

public abstract class InputHandler<T> {
    protected Converter<T> converter;
    protected Validator validator;

    abstract public void handle();

    abstract public T getHandledResult();
}
