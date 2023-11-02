package lotto.view;

import lotto.util.ErrorCode;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final String errorMessage = "[ERROR] %s";

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printError(ErrorCode errorCode) {
        System.out.printf(errorMessage, errorCode.getMessage());
    }
}
