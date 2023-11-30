package dto;

import domain.Rank;
import domain.WinningResult;

import java.util.List;
import java.util.Map;

public class WinningResultDto {
    private final Map<Rank, Integer> winningResult;
    private final double rateOfProfit;
    private static final String COUNT = "개\n";

    private WinningResultDto(final WinningResult winningResult) {
        this.winningResult = winningResult.getWinningResult();
        rateOfProfit = winningResult.getRateOfProfit();
    }

    public static WinningResultDto create(final WinningResult winningResult) {
        return new WinningResultDto(winningResult);
    }

    public String formatRateOfReturn(){
        double value = Math.round(rateOfProfit * 10.0) / 10.0;
        return String.format("%.1f", value);
    }

    public String generateResultString() {
        StringBuilder resultString = new StringBuilder();
        for (Rank rank : Rank.values()) {
            int count = winningResult.getOrDefault(rank, 0);
            resultString.append(rank.getMessage()).append(count).append(COUNT);
        }
        return resultString.toString();
    }
}
