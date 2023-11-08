package lotto.view;

import static lotto.util.Message.LottoMessage.FIFTH;
import static lotto.util.Message.LottoMessage.FOURTH;
import static lotto.util.Message.LottoMessage.THIRD;
import static lotto.util.Message.LottoMessage.SECOND;
import static lotto.util.Message.LottoMessage.FIRST;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    private final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private final String LINE = "---";
    private final String HEADLINE = "당첨 통계";
    private final String PROFIT = "총 수익률은 %.1f%%입니다.";

    public void printBuyLotto(List<Lotto> lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoValue());
        }
        System.out.println();
    }

    public void printWinningStatistics(HashMap<String, Integer> lottoResult) {
        System.out.println();
        System.out.println(HEADLINE);
        System.out.println(LINE);
        FIFTH.printMessage(lottoResult.get(FIFTH.getRank()));
        FOURTH.printMessage(lottoResult.get(FOURTH.getRank()));
        THIRD.printMessage(lottoResult.get(THIRD.getRank()));
        SECOND.printMessage(lottoResult.get(SECOND.getRank()));
        FIRST.printMessage(lottoResult.get(FIRST.getRank()));
    }

    public void printProfit(double winningProfit) {
        System.out.printf(PROFIT, winningProfit);
    }
}
