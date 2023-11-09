package lotto.view.console;

import java.text.DecimalFormat;
import lotto.dto.output.RankResultDTO;

public class OutputFormatter {
    private static final String RANK_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String RANK_BONUS_FORMAT = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_FORMAT = "0.#";

    private OutputFormatter() {
    }

    public static String formatRankResult(RankResultDTO rankResultDTO) {
        String rewardFormatted = formatNumber(rankResultDTO.getReward());
        if (rankResultDTO.isSecondRank()) {
            return formatSecondRank(rewardFormatted, rankResultDTO.getCount());
        }
        return formatRegularRank(rankResultDTO.getMatchCount(), rewardFormatted, rankResultDTO.getCount());
    }

    private static String formatSecondRank(String rewardFormatted, int count) {
        return String.format(RANK_BONUS_FORMAT, rewardFormatted, count);
    }

    private static String formatRegularRank(int matchCount, String rewardFormatted, int count) {
        return String.format(RANK_FORMAT, matchCount, rewardFormatted, count);
    }

    public static String formatProfitRate(double profitRate) {
        DecimalFormat df = new DecimalFormat(PROFIT_RATE_FORMAT);
        return df.format(profitRate);
    }

    private static String formatNumber(long number) {
        return String.format("%,d", number);
    }
}
