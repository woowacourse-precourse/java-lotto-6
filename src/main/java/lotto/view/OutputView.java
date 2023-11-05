package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningRank;

public class OutputView {

    public void lottoPurchaseCountMessage(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public void lottoNumbersMessage(Lottos lottos) {
        lottos.printLottoNumbers();
    }

    public void winningHistoryMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(WinningRank.getWinningHistory());
    }

    public void TotalReturnRateMessage(int inputPrice) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", WinningRank.calculateTotalPrizeMoney() / inputPrice * 100);
    }
}
