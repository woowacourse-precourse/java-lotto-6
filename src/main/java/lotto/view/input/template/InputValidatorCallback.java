package lotto.view.input.template;

public interface InputValidatorCallback<T> {
    T validate(String input);
}