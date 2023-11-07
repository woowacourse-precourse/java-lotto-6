package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        printEmptyLine();
        System.out.printf("%d개를 구매했습니다.\n",lottos.count());
        for (Lotto lotto : lottos.get()) {
            System.out.println(lotto.getSortedNumbers());
        }
        printEmptyLine();
    }
}
