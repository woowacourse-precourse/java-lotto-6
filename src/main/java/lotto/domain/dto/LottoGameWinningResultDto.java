package lotto.domain.dto;

import java.util.List;
import lotto.domain.LottoGame;

public class LottoGameWinningResultDto {

    private final List<Integer> rankings;
    private double rateOfReturn;

    public LottoGameWinningResultDto(List<Integer> rankings, double rateOfReturn) {
        this.rankings = rankings;
        this.rateOfReturn = rateOfReturn;
    }

    public static LottoGameWinningResultDto from(LottoGame lottoGame) {
        return new LottoGameWinningResultDto(
                lottoGame.getRankings(),
                lottoGame.getRateOfReturn());
    }
}
