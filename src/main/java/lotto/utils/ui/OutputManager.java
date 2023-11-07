package lotto.utils.ui;

import lotto.domain.Lottos;

public class OutputManager {
    public void printLottos(final String purchaseMessage, Lottos lottos) {
        System.out.println(purchaseMessage);
        System.out.println(lottos);
    }
}
