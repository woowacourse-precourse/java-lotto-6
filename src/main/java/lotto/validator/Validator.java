package lotto.validator;

public interface Validator {
    void check(String input) throws IllegalArgumentException;
}
