package lotto.domain.dto;

import java.util.List;

public class LottoGameWinningResultDto {

    private final List<Integer> rankings;
    private double rateOfReturn;

    public LottoGameWinningResultDto(final List<Integer> rankings, final double rateOfReturn) {
        this.rankings = rankings;
        this.rateOfReturn = rateOfReturn;
    }
}
