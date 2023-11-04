package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoCount(int purchasedCount) {
        printNewLine();
        System.out.printf(String.format("%d개를 구매했습니다.", purchasedCount));
    }

    public void printLottos(List<Lotto> lottos) {
        printNewLine();
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printInputWinningNumbersMessage() {
        printNewLine();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printNewLine() {
        System.out.println();
    }
}
