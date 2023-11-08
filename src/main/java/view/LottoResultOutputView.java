package view;

import java.util.Map;
import static model.LottoRepository.*;

public class LottoResultOutputView {
    public static final String WINNING_RESULT_HEADER = "당첨 통계\n---";
    public static final String MATCH_THREE_PRIZE = "3개 일치 (5,000원) - ";
    public static final String MATCH_FOUR_PRIZE = "4개 일치 (50,000원) - ";
    public static final String MATCH_FIVE_PRIZE = "5개 일치 (1,500,000원) - ";
    public static final String MATCH_FIVE_WITH_BONUS_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String MATCH_SIX_PRIZE = "6개 일치 (2,000,000,000원) - ";
    public static final String LOTTO_PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void showWinningResult(Map<Rank, Integer> lottoWinningStatistics) {
        System.out.println(WINNING_RESULT_HEADER);
        System.out.println(MATCH_THREE_PRIZE + lottoWinningStatistics.get(Rank.FIFTH) + "개");
        System.out.println(MATCH_FOUR_PRIZE + lottoWinningStatistics.get(Rank.FOURTH) + "개");
        System.out.println(MATCH_FIVE_PRIZE + lottoWinningStatistics.get(Rank.THIRD) + "개");
        System.out.println(MATCH_FIVE_WITH_BONUS_PRIZE + lottoWinningStatistics.get(Rank.SECOND) + "개");
        System.out.println(MATCH_SIX_PRIZE + lottoWinningStatistics.get(Rank.FIRST) + "개");
    }

    public void showLottoProfit(double profit) {
        System.out.printf(LOTTO_PROFIT_FORMAT, profit);
    }
}
