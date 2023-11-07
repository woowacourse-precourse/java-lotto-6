package lotto.formatter;

import lotto.constants.ProgressMessage;
import lotto.constants.WinningFactor;

import java.text.NumberFormat;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResultFormatter {
    private static final String DELIMITER_ENTER = "\n";
    private static final String SPACE = " ";

    private final Map<WinningFactor, Integer> statistics;
    private final Double totalRate;

    public GameResultFormatter(Map<WinningFactor, Integer> statistics, Double totalRate) {
        this.statistics = statistics;
        this.totalRate = totalRate;
    }

    public String toStatisticsResultMessage() {
        return statistics.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningFactor.NONE_MATCH)
                .map(entry -> buildStatisticsMessage(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(DELIMITER_ENTER));
    }

    private String buildStatisticsMessage(WinningFactor winningFactor, Integer count) {
        return String.format(ProgressMessage.WINNING_FACTOR_COUNT, winningFactor.getCount(),
                bonusMatchMessage(winningFactor), NumberFormat.getInstance().format(winningFactor.getMoney()), count);
    }

    private String bonusMatchMessage(WinningFactor winningFactor) {
        if (Boolean.TRUE.equals(winningFactor.isMatchBonusNumber())) {
            return ProgressMessage.MATCH_BONUS_BALL;
        }
        return SPACE;
    }

    public String toTotalRateMessage() {
        return String.format(ProgressMessage.TOTAL_RATE, totalRate);
    }
}
