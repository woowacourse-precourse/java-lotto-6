package lotto.domain.formatter;

import java.util.Map;
import lotto.domain.Prize;

public class PrizeResultFormatter {
    private static final String NEWLINE = "\n";
    private static final String MATCH_FORMAT = "%d개 일치";
    private static final String BONUS_MATCH_FORMAT = ", 보너스 볼 일치";
    private static final String PRIZE_FORMAT = "(%,d원)";
    private static final String SPACE = " ";
    private static final String DASH = " - ";
    private static final String UNIT = "개";

    public static String formatPrizeResult(Map<Prize, Integer> prizeResult) {
        StringBuilder sb = new StringBuilder();
        for (Prize prize : Prize.values()) {
            if (prize != Prize.EMPTY) {
                sb.append(formatPrize(prize, prizeResult.get(prize)));
            }
        }
        return sb.toString().trim();
    }

    private static String formatPrize(Prize prize, int count) {
        String matchString = matchString(prize);
        String prizeString = prizeString(prize);
        return matchString + SPACE + prizeString + DASH + count + UNIT + NEWLINE;
    }

    private static String matchString(Prize prize) {
        int matchLottoNumber = prize.getMatchLottoNumber();
        String matchString = String.format(MATCH_FORMAT, matchLottoNumber);
        if (prize == Prize.SECOND) {
            matchString += BONUS_MATCH_FORMAT;
        }
        return matchString;
    }

    private static String prizeString(Prize prize) {
        return String.format(PRIZE_FORMAT, prize.getWinningPrize());
    }
}
