package lotto.view;

import static lotto.util.message.ViewMessages.INPUT_USER_MONEY;

public class OutputView {
    public void printUserMoneyInputGuide() {
        println(INPUT_USER_MONEY);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
