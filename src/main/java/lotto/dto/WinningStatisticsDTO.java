package lotto.dto;

import lotto.domain.LottoResult;

public record WinningStatisticsDTO(LottoResult lottoResult, double rateOfReturn) {
    @Override
    public LottoResult lottoResult() {
        return lottoResult;
    }

    @Override
    public double rateOfReturn() {
        return rateOfReturn;
    }
}
