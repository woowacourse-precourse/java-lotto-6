package lotto;

public class InputException extends IllegalArgumentException {
    public InputException(String message) {
        super("[ERROR] " + message);
    }
}
