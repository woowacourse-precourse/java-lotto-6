package lotto.repository;

import lotto.domain.LottoWinning;

public class LottoWinningRepository {
    private static LottoWinning lottoWinning;

    public void save(LottoWinning lottoWinning){
        LottoWinningRepository.lottoWinning = lottoWinning;
    }
}
