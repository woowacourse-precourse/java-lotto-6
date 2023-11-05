package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Rank;

public class LottoUtil {
    private static final String MATCH_COUNT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    public static void sortByAsc(List<Integer> numbers) {
        numbers.sort(null);
    }

    public static List<Integer> convert(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String convertToDisplayFormat(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }

    public static String convertResultToDisplayFormat(Map<Rank, Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NO_RANK)) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                convertSecondRankToDisplayFormat(sb, result.getOrDefault(Rank.SECOND, 0));
                continue;
            }
            sb.append(String.format(MATCH_COUNT_FORMAT, rank.getMatchingCount(),
                    convertPrizeToDisplayFormat(rank.getPrize()),
                    result.getOrDefault(rank, 0)));
        }
        return sb.toString();
    }

    public static void convertSecondRankToDisplayFormat(StringBuilder sb, int count) {
        sb.append(String.format(SECOND_RANK_FORMAT, Rank.SECOND.getMatchingCount(),
                LottoUtil.convertPrizeToDisplayFormat(Rank.SECOND.getPrize()),
                count));
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
