package lotto.console;

import lotto.SoldLotto;

public class LottoOutputConsole {
    private static final String PRINT_MESSAGE_LOTTO = "개를 구매했습니다.";

    public void printSoldLotto(SoldLotto soldLotto) {
        System.out.println(soldLotto.getSoldLottoTicketsCount() + PRINT_MESSAGE_LOTTO);
        System.out.println(soldLotto);
    }
}
