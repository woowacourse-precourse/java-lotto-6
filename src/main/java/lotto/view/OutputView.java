package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    public void anounceLottos(Lottos lottos) {
        System.out.printf(PURCHASE_MESSAGE, lottos.getLottoCnt());
        lottos.anounceLottos();
    }
}
