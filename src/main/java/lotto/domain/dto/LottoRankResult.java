package lotto.domain.dto;

import lotto.domain.LottoRank;

public class LottoRankResult {

    private LottoRank result;

    private LottoRankResult(LottoRank result) {
        this.result = result;
    }

    public static LottoRankResult from(LottoRank lottoRank) {
        return new LottoRankResult(lottoRank);
    }
}
