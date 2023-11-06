package lotto.services;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;
import lotto.enums.LottoPrize;

public class PrizeResultStringGenerator {
    private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치(%s원) - %d개";

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
        String resultFormat = DEFAULT_RANK_PRINT_FORMAT;
        if (prize.isBonus()) {
            resultFormat = BONUS_RANK_PRINT_FORMAT;
        }
        return String.format(resultFormat, prize.getMatchCount(), formatCurrency(prize.getPrizeAmount()), count);
    }

    private static String formatCurrency(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(amount);
    }
}
