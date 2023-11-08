package lotto.domain.winning;

import static lotto.utils.constant.BuyPrice.LOTTO_PRICE;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private static final String RESULT_FORMAT_MESSAGE = "%d개 일치%s (%s원) - %d개";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다.";
    public static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    public static final String EMPTY_MESSAGE = "";
    public static final String CURRENCY_UNIT = "#,###";
    public static final String WINNING_RESULT_MESSAGES_DELIMITER = "\n";
    public static final int DEFAULT_VALUE = 0;
    public static final String PROFIT_RATE_FORMAT = "%.1f";

    private final Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);

    public void addWinning(Rank rank) {
        winningResult.put(rank, winningResult.getOrDefault(rank, DEFAULT_VALUE) + 1);
    }

    public String getResultMessage() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.FAIL)
                .map(rank -> String.format(RESULT_FORMAT_MESSAGE, rank.getMatchCount(), getSecondMessage(rank), getFormatNumberWithCommas(rank), getMatchCount(rank)))
                .collect(Collectors.joining(WINNING_RESULT_MESSAGES_DELIMITER));
    }

    private Integer getMatchCount(Rank rank) {
        return winningResult.getOrDefault(rank, DEFAULT_VALUE);
    }

    private String getSecondMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return BONUS_MATCH_MESSAGE;
        }
        return EMPTY_MESSAGE;
    }

    public String getFormatNumberWithCommas(Rank rank) {
        DecimalFormat decimalFormat = new DecimalFormat(CURRENCY_UNIT);
        return decimalFormat.format(rank.getReward());
    }

    public String getProfitRateMessage(int count) {
        return String.format(PROFIT_RATE_MESSAGE, getProfitRate(count));
    }

    private String getProfitRate(int count) {
        long sumReward = getSumReward();
        double profitRate = (double) sumReward / (count * LOTTO_PRICE) * 100;

        return String.format(PROFIT_RATE_FORMAT, profitRate);
    }

    private long getSumReward() {
        return winningResult.keySet().stream()
                .map(rank -> rank.getReward() * winningResult.getOrDefault(rank, DEFAULT_VALUE))
                .mapToLong(Long::valueOf)
                .sum();
    }
}
