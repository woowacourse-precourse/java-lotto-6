package lotto.view;

import java.util.stream.Collectors;
import lotto.PurchasedLottos;

public class OutputView {
    private static final String PURCHASED_LOTTOS_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public void outputPurchasedLottos(PurchasedLottos purchasedLottos) {

        outputPurchasedLottosCount(purchasedLottos);

        purchasedLottos.getCurrentPurchasedLottosSnapshot()
                .stream()
                .map(lotto -> lotto.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)))
                .forEach(System.out::println);
    }

    private void outputPurchasedLottosCount(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASED_LOTTOS_COUNT_MESSAGE, purchasedLottos.purchasedLottosCount());
    }
}
