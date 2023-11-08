package lotto.view.output;

import lotto.constant.RankCategory;
import lotto.model.ProfitRate;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String MATCHING_NUMBERS_FORMAT = "%d개 일치";
    private static final String PRIZE_FORMAT = " (%s원)";
    private static final String COUNT_FORMAT = " - %d개\n";
    private static final String SECOND_CATEGORY_BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String DECIMAL_FORMAT_PATTERN = "###,###";
    private static final String PROFIT_RATE_PATTERN = "%.1f";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String LOTTO_SEPARATOR = ", ";

    public static void formatRankCategory(StringBuilder sb, RankCategory rankCategory, int count) {
        sb.append(String.format(MATCHING_NUMBERS_FORMAT, rankCategory.getMatchingNumbers()))
                .append(String.format(PRIZE_FORMAT, formatPrize(rankCategory.getPrize())))
                .append((String.format(COUNT_FORMAT, count)));
    }

    public static void formatSecondCategory(StringBuilder sb, RankCategory rankCategory, int count) {
        sb.append(String.format(MATCHING_NUMBERS_FORMAT, rankCategory.getMatchingNumbers()))
                .append(SECOND_CATEGORY_BONUS_MATCH)
                .append(String.format(PRIZE_FORMAT, formatPrize(rankCategory.getPrize())))
                .append((String.format(COUNT_FORMAT, count)));
    }

    public static void formatProfitRate(ProfitRate profitRate, StringBuilder sb) {
        sb.append(String.format(PROFIT_RATE_FORMAT, formatProfitRate(profitRate)));
    }


    public static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_SEPARATOR, LOTTO_PREFIX, LOTTO_SUFFIX));
    }

    private static String formatProfitRate(ProfitRate profitRate) {
        return String.format(PROFIT_RATE_PATTERN, profitRate.rate());
    }

    private static String formatPrize(int prize) {
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT_PATTERN);
        return df.format(prize);
    }
}
