package lotto.dto;

import lotto.model.Statistics;

public class StatisticsDto {
    private Statistics statistics;

    private StatisticsDto(Statistics statistics) {
        this.statistics = statistics;
    }

    public static StatisticsDto createStatisticsDto(Statistics statistics) {
        return new StatisticsDto(statistics);
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
