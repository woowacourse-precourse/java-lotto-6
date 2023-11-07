package lotto;

public class IllegalArgumentExceptionHandler {
    public IllegalArgumentExceptionHandler(String message) {
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + message);
        }
    }
}
