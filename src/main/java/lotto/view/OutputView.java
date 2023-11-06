package lotto.view;

import lotto.constant.ErrorMessage;
import lotto.constant.GeneralMessage;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage) {
        System.out.println(generalMessage.getMessage());
    }

    public static void printGeneralMessage(GeneralMessage generalMessage, Object... args) {
        System.out.printf(generalMessage.getMessage() + "%n", args);
    }

    public static void printErrorMessage(String message) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(message);
    }
}
