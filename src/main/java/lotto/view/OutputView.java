package lotto.view;

public class OutputView {
    private static final String EXCEPTION_MESSAGE_FORMAT = "[ERROR] %s\n";

    public void printExceptionMessage(Exception exception) {
        String message = makeExceptionView(exception);
        print(message);
    }

    private String makeExceptionView(Exception exception) {
        return EXCEPTION_MESSAGE_FORMAT.formatted(exception.getMessage());
    }

    private void print(String message) {
        System.out.print(message);
    }
}
