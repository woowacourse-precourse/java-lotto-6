package lotto.view;

import lotto.enums.ErrorMessage;

public class ErrorView {
    private static final ErrorView singleton = new ErrorView();

    private ErrorView() {}

    public static ErrorView getInstance() {
        return singleton;
    }

    public void printErrorPage(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getMessage());
    }
}
