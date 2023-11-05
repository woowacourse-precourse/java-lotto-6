package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    private static final String PURCHASE_RESULT = "%d개를 구매했습니다.%n";

    public void printPurchaseResult(Lottos lottos) {
        System.out.printf(PURCHASE_RESULT, lottos.size());
        lottos.stream().forEach(System.out::println);
    }
}
