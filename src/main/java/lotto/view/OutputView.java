package lotto.view;

import lotto.model.Money;

public class OutputView {
    private static final String OUTPUT_BUY_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printByLottoCount(Money money) {
        System.out.printf(OUTPUT_BUY_LOTTO_COUNT_MESSAGE + "\n", money.getLottoCount());
    }
}
