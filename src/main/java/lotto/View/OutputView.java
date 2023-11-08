package lotto.View;

import lotto.constant.ErrorMessage;

public class OutputView {
    public static void printError(String message) {
        System.out.println(ErrorMessage.ERROR.getMessage() + message);
    }
}
