package lotto.dto;

import lotto.domain.WinningResult;

public record WinningStatisticsDTO(String[][] winningStatisticsStrings, double rateOfReturn) {
    @Override
    public String[][] winningStatisticsStrings() {
        return winningStatisticsStrings;
    }

    @Override
    public double rateOfReturn() {
        return rateOfReturn;
    }
}
