package lotto.validation;

public interface Validation {
    public abstract void check(String input) throws IllegalArgumentException;
}
