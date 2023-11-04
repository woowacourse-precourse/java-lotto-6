package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;

public class Output {

    private static final String LOTTOS_COUNT = "%d개를 구매했습니다.\n";

    public static void printLottosCount(Money money) {
        System.out.printf(LOTTOS_COUNT, money.getCount());
    }

    public static void printLottos(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
