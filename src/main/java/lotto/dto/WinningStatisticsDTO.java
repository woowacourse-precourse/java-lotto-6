package lotto.dto;

import lotto.domain.WinningResult;

public record WinningStatisticsDTO(WinningResult lottoResult, double rateOfReturn) {
    @Override
    public WinningResult lottoResult() {
        return lottoResult;
    }

    @Override
    public double rateOfReturn() {
        return rateOfReturn;
    }
}
