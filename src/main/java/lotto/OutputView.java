package lotto;

import static lotto.Constants.REQUEST_BUY_MONEY;
import static lotto.Constants.TICKET_COUNT;

public class OutputView {
    public static void printRequestMoney() {
        System.out.println(REQUEST_BUY_MONEY);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + TICKET_COUNT);
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
