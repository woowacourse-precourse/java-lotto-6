package view;

import java.util.Map;
import static model.LottoRepository.*;

public class LottoResultOutputView {
    public void showWinningResult(Map<Integer, Integer> lottoWinningStatistics) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + lottoWinningStatistics.get(RANK_FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningStatistics.get(RANK_FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningStatistics.get(RANK_THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningStatistics.get(RANK_SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningStatistics.get(RANK_FIRST) + "개");
    }

    public void showLottoProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
