package lotto.view;

public class OutputView {
    public static void moneyMessage() {
        System.out.println(Message.MONEY.getMessage());
    }

    public static void winningMessage() {
        System.out.println(Message.WINNING_NUM.getMessage());
    }

    public static void bonusMessage() {
        System.out.println(Message.BONUS_NUM.getMessage());
    }
}
