package lotto.view;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printExceptionMessage(String exceptionMessage) {
        String formattedExceptionMessage = String.format(EXCEPTION_FORMAT, exceptionMessage);
        println(formattedExceptionMessage);
    }

    public void println(String message) {
        System.out.println(message);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
