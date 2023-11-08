package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Message;

public class ConsoleView {

    public static void printInputPurchaseAmountMessage() {
        System.out.println(Message.inputPurchaseAmount);
    }

    public static void printPurchaseConfirmationMessage(int n) {
        System.out.println(n + Message.purchaseConfirmation);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(Message.inputWinningNumbers);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(Message.inputBonusNumber);
    }

    public static void printWinningStatistics() {
        System.out.println(Message.winningStatistics);
    }

    public static void printLottos(Lotto[] lottos) {

        for (Lotto lotto: lottos) {
            StringBuilder sb = new StringBuilder();
            System.out.print("[");
            for (int number: lotto.getNumbers()) {
                sb.append(number).append(", ");
            }
            System.out.print(sb.substring(0, sb.length() - 2));
            System.out.println("]");
        }
    }
}
