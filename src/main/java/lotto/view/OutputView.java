package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;

public class OutputView {
    private static final String TICKET_COUNT = "%d개를 구매했습니다.";

    public static void printBuyLotto(Money money) {
        System.out.printf((TICKET_COUNT) + "%n", money.getTicket());
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
