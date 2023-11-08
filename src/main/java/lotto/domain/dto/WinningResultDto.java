package lotto.domain.dto;

import lotto.domain.result.Ranking;
import lotto.domain.result.WinningResult;

import java.util.Collections;
import java.util.Map;

public class WinningResultDto {
    private static final long ZERO_FOR_INVALID_KEY = 0L;

    private Map<Ranking, Long> result;
    private double rateOfReturnPercent;

    private WinningResultDto(Map<Ranking, Long> result, double rateOfReturnPercent) {
        this.result = Collections.unmodifiableMap(result);
        this.rateOfReturnPercent = rateOfReturnPercent;
    }

    public static WinningResultDto of(WinningResult winningResult) {
        return new WinningResultDto(winningResult.getResult(), winningResult.getRateOfReturnPercent());
    }


    public double getRateOfReturnPercent() {
        return rateOfReturnPercent;
    }

    public Long getWinningCount(Ranking ranking) {
        return result.getOrDefault(ranking, ZERO_FOR_INVALID_KEY);
    }
}

