package lotto.view;

import lotto.domain.Money;

public class OutputView {
    public static void printLottoQuantity(Money money) {
        System.out.printf("%d개를 구매했습니다.%n", money.getLottoQuantity());
    }
}
