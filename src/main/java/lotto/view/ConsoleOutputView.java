package lotto.view;

public class ConsoleOutputView implements OutputView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    @Override
    public void print(String value) {
        System.out.println(value);
    }

    @Override
    public void printError(Exception error) {
        print(ERROR_MESSAGE_PREFIX + error.getMessage());
    }

}
