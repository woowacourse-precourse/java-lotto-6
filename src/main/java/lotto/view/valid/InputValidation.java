package lotto.view.valid;

public interface InputValidation<T> {

    T validateInput(final String inputText, final ViewValidator viewValidator);
}
