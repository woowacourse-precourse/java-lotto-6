package lotto.common;

public class IllegalArgumentExceptionHandler {
    public void handleException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
