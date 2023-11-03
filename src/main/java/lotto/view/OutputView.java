package lotto.view;

import lotto.domain.LottoTickets;

public class OutputView {
    private static Integer PRICE=1000;
    public static void moneyMessage() {
        System.out.println(Message.MONEY.getMessage());
    }

    public static void buyComplete(Integer money) {
        System.out.printf("\n%d개를 구매했습니다.\n",money/1000);
    }

    public static void printLotto(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.toString());
    }

    public static void winningMessage() {
        System.out.println(Message.WINNING_NUM.getMessage());
    }

    public static void bonusMessage() {
        System.out.println(Message.BONUS_NUM.getMessage());
    }

    public static void errorMessage(String message) {
        System.out.printf("[ERROR] %s\n",message);
    }
}
