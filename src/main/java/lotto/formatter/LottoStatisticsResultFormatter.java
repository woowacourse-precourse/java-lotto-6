package lotto.formatter;

import lotto.constants.WinningFactor;

import java.text.NumberFormat;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatisticsResultFormatter {

    private final Map<WinningFactor, Integer> statistics;
    private final Double totalRate;

    public LottoStatisticsResultFormatter(Map<WinningFactor, Integer> statistics, Double totalRate) {
        this.statistics = statistics;
        this.totalRate = totalRate;
    }

    public String toStatisticsResultMessage() {
        return statistics.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningFactor.NONE_MATCH)
                .map(entry -> buildStatisticsMessage(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private String buildStatisticsMessage(WinningFactor winningFactor, int count) {
        return String.format("%d개 일치%s(%s원) - %d개", winningFactor.getCount(),
                bonusMatchMessage(winningFactor), NumberFormat.getInstance().format(winningFactor.getMoney()), count);
    }

    private String bonusMatchMessage(WinningFactor winningFactor) {
        if (Boolean.TRUE.equals(winningFactor.isMatchBonusNumber())) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }

    public String toTotalRateMessage() {
        return String.format("총 수익률은 %s%%입니다.", totalRate);
    }
}
