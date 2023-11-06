package view;

import lotto.Money;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottoCount(Money money) {
        System.out.print("\n" + money.getLottoCount());
        System.out.println(LOTTO_COUNT_MESSAGE);
    }
}
