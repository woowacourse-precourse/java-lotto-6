package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    private static final String LOTTO_QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public void printLottos(Lottos lottos) {
        System.out.println();
        printLottoQuantity(lottos);
        System.out.println(lottos);
    }

    private static void printLottoQuantity(Lottos lottos) {
        System.out.println(String.format(LOTTO_QUANTITY_MESSAGE_FORMAT, lottos.getLottos().size()));
    }
}
