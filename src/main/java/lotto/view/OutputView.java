package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchaseCount(int purchaseCount) {
        System.out.printf("%s개를 구매했습니다.\n", purchaseCount);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
