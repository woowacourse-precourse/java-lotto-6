package lotto.services;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;
import lotto.enums.LottoPrize;

public class PrizeResultStringGenerator {
    private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static String generatePrizeResults(EnumMap<LottoPrize, Integer> prizes) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LottoPrize, Integer> entry : prizes.entrySet()) {
            LottoPrize prize = entry.getKey();
            int count = entry.getValue();

            String formattedResult = formatPrizeResult(prize, count);
            sb.append(formattedResult).append("\n");
        }
        return sb.toString();
    }

    private static String formatPrizeResult(LottoPrize prize, int count) {
        String resultFormat = selectResultSentence(prize);
        return buildFormattedResult(prize, count, resultFormat);
    }

    private static String selectResultSentence(LottoPrize prize) {
        String resultFormat = DEFAULT_RANK_PRINT_FORMAT;
        if (prize.isBonus()) {
            resultFormat = BONUS_RANK_PRINT_FORMAT;
        }
        return resultFormat;
    }

    private static String buildFormattedResult(LottoPrize prize, int count, String resultFormat) {
        int matchCount = prize.getMatchCount();
        BigDecimal prizeAmount = BigDecimal.valueOf(prize.getPrizeAmount());

        return String.format(resultFormat, matchCount, formatCurrency(prizeAmount), count);
    }

    public static String formatCurrency(BigDecimal amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(amount);
    }
}
