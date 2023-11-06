package lotto.io;

import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PrizeRank;

public class OutputView {

    private static final String STATISTICS_TITLE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String WINNING_MESSAGE_FORMAT = "%s - %d개";

    public void displayLottosCnt(int cnt) {
        displayEmptyLine();
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningResult(Map<PrizeRank, Integer> result) {
        displayEmptyLine();
        System.out.println(STATISTICS_TITLE);
        System.out.println(LINE_SEPARATOR);
        for (Entry<PrizeRank, Integer> entry : result.entrySet()) {
            if (entry.getKey().equals(PrizeRank.NOPE)) {
                continue;
            }
            String message = PrizeRank.getMsg(entry.getKey());
            System.out.printf((WINNING_MESSAGE_FORMAT) + "%n", message, entry.getValue());
        }
    }

    public void displayProfitRate(Double profitRate) {
        System.out.printf("총 수익률은 %s%%입니다.", profitRate);
    }

    private void displayEmptyLine() {
        System.out.println();
    }
}
