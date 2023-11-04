package lotto.util;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.constant.LottoRankExpression;
import lotto.domain.model.LottoRanks;

public class LottoStatistics {
    private static final int MULTIPLYING_NUMBER = 100;
    private static final String PREFIX_MESSAGE = "\n당첨 통계\n---\n";
    private static final String RATE_OF_RETURN_EXPRESSION = "총 수익률은 %.1f%%입니다.";
    private static final List<LottoRankExpression> ORDERED_EXPRESSIONS = List.of(
            LottoRankExpression.THREE,
            LottoRankExpression.FOUR,
            LottoRankExpression.FIVE_WITHOUT_BONUS,
            LottoRankExpression.FIVE_WITH_BONUS,
            LottoRankExpression.SIX
    );

    private static int getLottoRankCountByLottoRankExpression(
            Map<LottoRank, Integer> rankCounts, LottoRankExpression lottoRankExpression) {

        LottoRank lottoRank = lottoRankExpression.getLottoRank();

        return rankCounts.get(lottoRank);
    }
    private static String getLottoRankCountByLottoRankExpressions(Map<LottoRank, Integer> rankCounts) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoRankExpression lottoRankExpression : ORDERED_EXPRESSIONS) {
            int count = getLottoRankCountByLottoRankExpression(rankCounts, lottoRankExpression);
            String rankExpression = lottoRankExpression.getExpressionByCount(count);

            stringBuilder.append(rankExpression);
        }

        return stringBuilder.toString();
    }

    private static String createRateOfReturnExpression(LottoRanks lottoRanks, long costAmount) {
        double winningSum = Long.valueOf(lottoRanks.getWinningSum()).doubleValue();
        double rateOfReturn = winningSum / costAmount * MULTIPLYING_NUMBER;

        return String.format(RATE_OF_RETURN_EXPRESSION, rateOfReturn);
    }

    public static String createStatisticsExpression(LottoRanks lottoRanks, long costAmount) {
        Map<LottoRank, Integer> rankCounts = lottoRanks.getRankCounts();
        String lottoRankCountExpressions = getLottoRankCountByLottoRankExpressions(rankCounts);
        String rateOfReturnExpression = createRateOfReturnExpression(lottoRanks, costAmount);

        return PREFIX_MESSAGE + lottoRankCountExpressions + rateOfReturnExpression;
    }
}
