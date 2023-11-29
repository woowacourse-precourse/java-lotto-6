package lotto.view.input.Template;

public interface InputValidatorCallback<T> {
    T validate(String input);
}