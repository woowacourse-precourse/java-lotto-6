package lotto.view;

import static lotto.view.OutputMessage.PURCHASE_RESULT;
import static lotto.view.OutputMessage.SEPARATOR;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void purchaseResult(int number) {
        System.out.println(number + PURCHASE_RESULT.getMessage());
    }

    public void winningStatistics() {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println(SEPARATOR.getMessage());
    }
}
