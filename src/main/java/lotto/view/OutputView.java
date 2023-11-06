package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;

public class OutputView {

    private static final String SHOW_LOTTO = "\n%d개를 구매했습니다.\n";

    public void showLottos(Lottos lottos, Money money) {
        System.out.printf(SHOW_LOTTO, money.calNumberOfLotto());
        lottos.showLottos();
        printLine();
    }

    public void printLine() {
        System.out.println();
    }

}
