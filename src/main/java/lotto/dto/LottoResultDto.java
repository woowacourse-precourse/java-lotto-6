package lotto.dto;

import lotto.domain.result.LottoCalculateResult;
import lotto.domain.result.LottoMatchResult;

public class LottoResultDto {
    private final LottoMatchResult lottoMatchResult;
    private final LottoCalculateResult lottoCalculateResult;

    private LottoResultDto(LottoMatchResult lottoMatchResult, LottoCalculateResult lottoCalculateResult) {
        this.lottoMatchResult = lottoMatchResult;
        this.lottoCalculateResult = lottoCalculateResult;
    }

    public static LottoResultDto fromMatchAndCalculateResults(LottoMatchResult matchResult, LottoCalculateResult calculateResult) {
        return new LottoResultDto(matchResult, calculateResult);
    }

    public LottoMatchResult getLottoMatchResult() {
        return lottoMatchResult;
    }

    public LottoCalculateResult getLottoCalculateResult() {
        return lottoCalculateResult;
    }
}
