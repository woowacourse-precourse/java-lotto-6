package lotto.io;

import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PrizeRank;

public class OutputView {

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
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Entry<PrizeRank, Integer> entry : result.entrySet()) {
            if (entry.getKey().equals(PrizeRank.NOPE)) {
                continue;
            }
            System.out.println(PrizeRank.getMsg(entry.getKey()) + " - " + entry.getValue() + "개");
        }
    }

    public void displayProfitRate(Double profitRate) {
        System.out.printf("총 수익률은 %s%%입니다.", profitRate);
    }

    private void displayEmptyLine() {
        System.out.println();
    }
}
