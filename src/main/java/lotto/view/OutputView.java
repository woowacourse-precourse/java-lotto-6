package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n",lottos.count());
        for (Lotto lotto : lottos.get()) {
            System.out.println(lotto);
        }
    }
}
