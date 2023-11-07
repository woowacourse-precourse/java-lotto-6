package lotto.view.outputView;

import java.util.Arrays;
import lotto.model.Revenue;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.RankCount;

public class LottoResultOutputView {
    private static final String STATS_MESSAGE = "\n당첨 통계";
    private static final String DIVIDE_DELIMETER = "---";
    private static final String COUNT_FORMAT = "개";
    private static final String REVENUE_MESSAGE = "총 수익률은 %s%%입니다.";

    public void printLottoResult(RankCount rankCount) {
        System.out.println(STATS_MESSAGE);
        System.out.println(DIVIDE_DELIMETER);
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.FAIL)
                .forEach(rank -> System.out.println(rank.getMsg() + rankCount.getCounts(rank) + COUNT_FORMAT));
    }

    public void printRevenue(Revenue revenue){
        String revenueFormatted = revenue.getRevenue();
        System.out.printf(REVENUE_MESSAGE + "%n", revenueFormatted);
    }

}
