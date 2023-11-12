package lotto.dto;

public class StatisticDTO {
    private int[] statistic;

    public StatisticDTO(int[] statistic) {
        this.statistic = statistic;
    }

    public int[] getStatistic() {
        return statistic;
    }
}
