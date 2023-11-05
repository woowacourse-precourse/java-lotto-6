package lotto;

public class Validator {
    protected static void throwException(String message, Throwable e) {
        if (e != null) {
            throw new IllegalArgumentException("[ERROR] " + message, e);
        }
        throw new IllegalArgumentException("[ERROR] " + message);
    }
}
