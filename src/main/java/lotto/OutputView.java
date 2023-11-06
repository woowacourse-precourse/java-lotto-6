package lotto;

import static lotto.Constants.REQUEST_BUY_MONEY;
import static lotto.Constants.TICKET_COUNT;
import static lotto.Constants.REQUEST_WINNING_NUMBERS;

public class OutputView {
    public static void printRequestMoney() {
        System.out.println(REQUEST_BUY_MONEY);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT);
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBERS);
    }

    public static void printBlankLine() {
        System.out.println();
    }


}
