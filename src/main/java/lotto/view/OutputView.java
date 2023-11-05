package lotto.view;

import lotto.system.SystemMessage;

public class OutputView {
    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void inputMoney() {
        System.out.println(SystemMessage.INPUT_MONEY.getMessage());
    }

    public static void inputWinningNumbers() {
        System.out.println(SystemMessage.INPUT_WINNING_NUMBER.getMessage());
    }
}
