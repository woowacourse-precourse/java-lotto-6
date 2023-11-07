package lotto.view;

import lotto.constant.ErrorMessage;
import lotto.constant.GeneralMessage;

import static lotto.constant.GeneralMessage.NOTIFY_BUY_COUNT;

public class OutputView {
    public static void printGeneralMessage(GeneralMessage generalMessage, Object... args) {
        System.out.printf(generalMessage.getMessage(), args);
        System.out.println();
    }

    public static void printBuyLottos(int count, String result) {
        System.out.printf(NOTIFY_BUY_COUNT.getMessage(), count);
        System.out.println();
        System.out.println(result);
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(message);
    }
}
