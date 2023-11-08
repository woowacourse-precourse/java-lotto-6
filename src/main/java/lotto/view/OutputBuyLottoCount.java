package lotto.view;

import lotto.domain.Money;

public class OutputBuyLottoCount {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printBuyLotto(Money money) {
        System.out.printf((OUTPUT_MESSAGE) + "%n", money.getTicket());
    }
}
