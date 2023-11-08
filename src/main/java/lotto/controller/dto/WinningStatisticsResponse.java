package lotto.controller.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.LottoPrize;

public class WinningStatisticsResponse {

    private static final long DEFAULT = 0L;

    private final Map<String, Long> winningStatistics;

    private WinningStatisticsResponse(final Map<String, Long> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public static WinningStatisticsResponse from(final Map<LottoPrize, Long> lottos) {
        Map<String, Long> winningStatistics = new LinkedHashMap<>();

        Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize != LottoPrize.NO_PRIZE)
                .forEach(prize -> winningStatistics.put(prize.getDescription(), lottos.getOrDefault(prize, DEFAULT)));

        return new WinningStatisticsResponse(winningStatistics);
    }

    public Map<String, Long> getWinningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }
}

