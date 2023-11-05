package lotto.view;

public class OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";
    private static final String NEW_LINE = "\n";

    public void printExceptionMessage(Exception exception) {
        String message = makeExceptionView(exception);
        print(message);
    }

    private String makeExceptionView(Exception exception) {
        return EXCEPTION_MESSAGE_PREFIX
                .concat(exception.getMessage())
                .concat(NEW_LINE);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
