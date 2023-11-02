package lotto.io;

import lotto.domain.Lotto;

import java.util.List;

public class OutputProcessor {
    private static final String PURCHASE_INFORMATION_FORMAT = "%d개를 구매했습니다.";

    private OutputProcessor() {
    }

    public static void printPurchaseInformation(final List<Lotto> userLottos) {
        System.out.println(String.format(PURCHASE_INFORMATION_FORMAT, userLottos.size()));
        userLottos.forEach(System.out::println);
    }
}
