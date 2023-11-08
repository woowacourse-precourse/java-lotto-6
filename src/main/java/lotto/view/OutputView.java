package lotto.view;

import lotto.util.Message;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String errorMessageHeader = "[ERROR] %s\n";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printMessage(Message message, Object... args) {
        System.out.printf(message.getMessage() + "\n", args);
    }

    public void printObject(Object arg) {
        System.out.println(arg);
    }

    public void printError(String errorMessage) {
        System.out.printf(errorMessageHeader, errorMessage);
    }
}
