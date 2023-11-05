package lotto.view;

import lotto.system.SystemMessage;

public class OutputView {
    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
