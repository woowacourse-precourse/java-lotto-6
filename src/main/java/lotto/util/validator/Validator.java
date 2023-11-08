package lotto.util.validator;

public class Validator {
    public void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public void throwIllegalArgumentException(String message, Throwable t) {
        throw new IllegalArgumentException(message, t);
    }
}
