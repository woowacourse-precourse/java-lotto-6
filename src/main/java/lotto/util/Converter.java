package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Rank;
import lotto.model.RankResult;

public class Converter {
    private static final String MATCH_COUNT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String SEPARATOR = ", ";
    private static final String LOTTO_DISPLAY_PREFIX = "[";
    private static final String LOTTO_DISPLAY_SUFFIX = "]";

    public static String convertLottoToDisplayFormat(List<Integer> numbers) {
        return LOTTO_DISPLAY_PREFIX + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR)) + LOTTO_DISPLAY_SUFFIX;
    }

    public static String convertResultToDisplayFormat(RankResult result) {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            int count = result.getCountByRank(rank);
            if (rank.equals(Rank.NO_RANK)) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                sb.append(convertSecondRankToDisplayFormat(count));
                continue;
            }
            sb.append(convertRankToDisplayFormat(rank, count));
        }
        return sb.toString();
    }

    private static String convertRankToDisplayFormat(Rank rank, int count) {
        return String.format(MATCH_COUNT_FORMAT, rank.getMatchingCount(),
                Converter.convertPrizeToDisplayFormat(rank.getPrize()), count);
    }

    public static String convertSecondRankToDisplayFormat(int count) {
        return String.format(SECOND_RANK_FORMAT, Rank.SECOND.getMatchingCount(),
                Converter.convertPrizeToDisplayFormat(Rank.SECOND.getPrize()),
                count);
    }

    public static String convertPrizeToDisplayFormat(long prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        String convertedPrize = decimalFormat.format(prize);
        return convertedPrize;
    }

    public static String convertReturnRateToDisplayFormat(float rate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String convertedRate = decimalFormat.format(rate);
        return convertedRate;
    }
}
