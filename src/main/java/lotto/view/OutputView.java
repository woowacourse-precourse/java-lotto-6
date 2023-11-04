package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.List;

public class OutputView {
    public static void printBuyLotto(Money money) {
        System.out.printf("%d개를 구매했습니다.\n", money.getTicket());
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
