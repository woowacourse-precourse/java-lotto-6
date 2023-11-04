package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prizes;

public class outputView {

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.getCount());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStaticResult(Prizes prizes) {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
