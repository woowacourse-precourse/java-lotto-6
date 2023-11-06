package lotto.global.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String ENTER = System.lineSeparator();
    private static final String PURCHASED_COUNT_MESSAGE = ENTER + "%d개를 구매했습니다.";

    public static void printPurchaseCount(int count) {
        System.out.println(String.format(PURCHASED_COUNT_MESSAGE, count));
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = lotto.getNumbers().stream().sorted().toList();
            System.out.printf("%s%n", sortedLotto);
        }
    }
}
